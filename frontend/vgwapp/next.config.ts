import type { NextConfig } from "next";

const nextConfig: NextConfig = {
  /* config options here */
  images:{
    remotePatterns: [new URL('https://placehold.co/450x450')],
  }
};

export default nextConfig;
