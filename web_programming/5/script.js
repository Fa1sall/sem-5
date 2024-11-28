let currentImageIndex = 0;
const images = [
    "https://images.pexels.com/photos/771742/pexels-photo-771742.jpeg?cs=srgb&dl=adult-art-backlit-771742.jpg&fm=jpg",
    "https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?cs=srgb&dl=pexels-pixabay-220453.jpg&fm=jpg",
    "https://expertphotography.b-cdn.net/wp-content/uploads/2018/10/cool-profile-pictures-retouching-1.jpg",
    "https://avatars.githubusercontent.com/u/77320095?v=4",
    './image1.jpg'
];

function changeImage() {
    currentImageIndex = (currentImageIndex + 1) % images.length;
    document.getElementById('slider').src = images[currentImageIndex];
}

setInterval(changeImage, 5000);

let likeCount = 0;
document.getElementById('likeButton').addEventListener('click', () => {
    likeCount++;
    document.getElementById('likeCount').textContent = likeCount;
});

function toggleComments() {
    const commentSection = document.getElementById('commentSection');
    commentSection.classList.toggle('hidden');
}

function addComment() {
    const commentInput = document.getElementById('commentInput').value;
    if (commentInput) {
        const commentList = document.getElementById('commentList');
        const newComment = document.createElement('li');
        newComment.textContent = commentInput;
        commentList.appendChild(newComment);
        document.getElementById('commentInput').value = ''; 
    }
}
function updateTime() {
    const now = new Date();
    const timeString = now.toLocaleTimeString();
    document.getElementById('time').textContent = timeString;
}
updateTime();

setInterval(updateTime, 30000);