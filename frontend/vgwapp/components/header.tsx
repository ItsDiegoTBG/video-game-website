import Link from "next/link";

export const Header = ()=>{
    return(
        <nav className="sticky top-0 z-50 bg-white shadow">
            <div className="container mx-auto flex items-center justify-between px-4 py-4">
                <Link className="hover:text-blue-600" href={"/"}>VGW</Link>
                <div className="md:felx space-x-6">
                    <Link href={"/"}>Home</Link>
                    <Link className="hover:text-blue-600" href={"/products"}>Products</Link>
                    <Link className="hover:text-blue-600" href={"/contacts"}>Contact</Link>
                    <Link className="hover:text-blue-600" href={"/cart"}>Cart</Link>
                </div>
           <div className="flex items-center space-x-4">
                <Link href={"/register"}>Register</Link>
                <Link href={"/login"}>Sign in</Link>
            </div>
            </div>
        </nav>
    );
}