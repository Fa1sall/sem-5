let slideIndex = 0;

// Function to show the next slide
function showSlides() {
    let slides = document.querySelectorAll('.slide');
    
    // Hide all slides
    slides.forEach((slide) => {
        slide.style.display = "none";
    });

    // Increment the slide index, reset to 0 if it exceeds the number of slides
    slideIndex++;
    if (slideIndex > slides.length) {
        slideIndex = 1;
    }

    // Show the current slide
    slides[slideIndex - 1].style.display = "block";

    // Change image every 5 seconds
    setTimeout(showSlides, 5000); // Adjust timing here (5000ms = 5 seconds)
}

// Initialize the slideshow
showSlides();
