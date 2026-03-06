import { Button } from "@mui/material";
import { ShoppingCart } from "lucide-react";
import Link from "next/link";
import Image from "next/image";
import { Carousel } from "@/components/carousel";

export default async function Home() {
  const products = {}
  //GRAB 5 RANDOM ITEMS HERE TO PUT IMAGES

  //Check for different startIcons in MUI
  return (
    <div>
      <section className="rounded bg-neutral-100 py-8 sm:py-12">
        <div className="mx-auto grid grid-cols-1 items-center justify-items-center gap-8-px-8 sm:px-16">
          <div className="max-w-md space-y-4">
            <h2 className="text-3xl font-bond tracking-tight md:text-4xl">VGW</h2>
            <p className="text-neutral-600">Discover the best prices for our lastest products</p>

            <Button variant="contained" startIcon={<ShoppingCart />}>
              <Link href="/products">Browse Products</Link>
            </Button>
          </div>
          <Image unoptimized className= "rounded" alt="Banner Image" width={450} height={450} src={"https://placehold.co/450x450"}></Image>
        </div>
      </section>
      <section className="py-8">
        <Carousel></Carousel>
      </section>
    </div>
  );
}
