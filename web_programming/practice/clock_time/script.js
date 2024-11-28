function updateClock() {
    const timeElement = document.getElementById('time');
    const currentTime = new Date();
    const hours = currentTime.getHours().toString();
    const minutes = currentTime.getMinutes().toString();
    const seconds = currentTime.getSeconds().toString();

    timeElement.textContent = `${hours}:${minutes}:${seconds}`;
}

// Initial call to display the time
updateClock();

// Update time every 10 seconds
setInterval(updateClock, 10);
