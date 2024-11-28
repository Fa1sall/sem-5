const images = [
    "https://images.pexels.com/photos/771742/pexels-photo-771742.jpeg?cs=srgb&dl=adult-art-backlit-771742.jpg&fm=jpg",
    "https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?cs=srgb&dl=pexels-pixabay-220453.jpg&fm=jpg",
    "https://expertphotography.b-cdn.net/wp-content/uploads/2018/10/cool-profile-pictures-retouching-1.jpg",
    "https://avatars.githubusercontent.com/u/77320095?v=4",
    './image1.jpg'
];

let currentImageIndex = 0;

function changeImage(){
    const imageHolder = document.getElementById('imageHolder');
    currentImageIndex = (currentImageIndex+1) % images.length;
    imageHolder.src = images[currentImageIndex];
}

setInterval(changeImage,5000);