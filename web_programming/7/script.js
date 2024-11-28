const images = [
    'image1.jpg',
    'image2.jpg',
    'image3.jpg',
    'image4.jpg'
];

let currentIndex = 0;
const slide = document.getElementById('slide');

function changeImage() {
    currentIndex = (currentIndex + 1) % images.length;
    slide.src = images[currentIndex];
}

setInterval(changeImage, 5000); // Change image every 5 seconds
