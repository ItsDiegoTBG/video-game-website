package com.project.vgwebpage.Services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.vgwebpage.Entities.Product;
import com.project.vgwebpage.Repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    private final Path uploadPath = Paths.get("uploads").toAbsolutePath().normalize();


    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not Found"));
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    public String uploadPhoto(Integer id, MultipartFile file) {

        Product product = getProductById(id);

        try {
            String fileExtension = getFileExtension(file.getOriginalFilename());
            String fileName = id + fileExtension;

            Path targetLocation = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            String photoUrl = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/api/products/image/")
                    .path(fileName)
                    .toUriString();

            product.setPhotoUrl(photoUrl);
            productRepository.save(product);

            return photoUrl;

        } catch (IOException e) {
            throw new RuntimeException("Failed to store image", e);
        }
    }

    private String getFileExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            return ".png";
        }
        return filename.substring(filename.lastIndexOf("."));
    };

}
