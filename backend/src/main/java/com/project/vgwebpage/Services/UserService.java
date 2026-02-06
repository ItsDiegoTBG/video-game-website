package com.project.vgwebpage.Services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.vgwebpage.Entities.User;
import com.project.vgwebpage.Repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional(rollbackOn = Exception.class)
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(Integer id) {
    return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not Found"));
  }

  public void deleteUser(Integer id) {
    userRepository.deleteById(id);
  }

  public String uploadPhoto(Integer id, MultipartFile File) {
    User user = getUserById(id);
    String photoUrl = photoFunction.apply(id, File);
    user.setPhotoUrl(photoUrl);
    userRepository.save(user);
    return photoUrl;
  }

  private final Function<String, String> fileExtension = filename -> Optional.of(filename)
      .filter(name -> name.contains(".")).map(name -> "." + name.substring(filename.lastIndexOf(".")+1)).orElse(".png");

  private final BiFunction<Integer, MultipartFile, String> photoFunction = (id, image) -> {
    String filename = id + fileExtension.apply(image.getOriginalFilename());
    try {
      Path fileStorageLocation = Paths.get("").toAbsolutePath().normalize();
      if (!Files.exists(fileStorageLocation)) {
        Files.createDirectories(fileStorageLocation);
      }
      Files.copy(image.getInputStream(), fileStorageLocation.resolve(id + fileExtension.apply(image.getOriginalFilename())), StandardCopyOption.REPLACE_EXISTING );
      return ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/image/"+filename).toUriString();
    } catch (Exception e) {
      throw new RuntimeException("Unable to save Image");
    }
  };
}
