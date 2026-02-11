import Link from "next/link";

export const Header = ()=>{
    return(
        <nav className="sticky top-0 z-50 bg-white shadow">
            <div className="container mx-auto flex items-center justify-between px-4 py-4">
                <Link href={"/"}>VGW</Link>
            </div>
            <div>
                <Link href={"/"}>Home</Link>
                <Link href={"/products"}>Products</Link>
                <Link href={"/contacts"}>Contact</Link>
                <Link href={"/cart"}>Cart</Link>
            </div>
            <div>
                <Link href={"/register"}>Register</Link>
                <Link href={"/login"}>Sign in</Link>
                <Link href={"/"}></Link>
            </div>
        </nav>
    );
}