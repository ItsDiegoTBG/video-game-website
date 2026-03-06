import { ProductCard } from "./product-card";

export const ProductList = () =>{
    const products: any[] = [];

    return(
        <div>
        <div>
        <input type="text" placeholder="Search products..." />
        </div>

        <ul>
            {products.map((product)=>{
                return <li>
                    <ProductCard product={product}/>
                </li>
            })}
        </ul>
        </div>
    )
}