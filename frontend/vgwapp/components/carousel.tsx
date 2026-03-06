import { Card, CardMedia, Typography } from "@mui/material"

export const Carousel = () => {


    
    return <div>
        <Card className={"bg-card text-card-foreground flex flex-col gap-6 rounded-xl border"}>
            <CardMedia
                component="img"
                alt="Contemplative Reptile"
                height="200"
                image={"https://placehold.co/450x450"}
                title="Contemplative Reptile"
            />
            <Typography
                gutterBottom
                variant="h1"
                component="h1"
            >
                Products
            </Typography>
        </Card>
    </div>
}