function initMap() {
    // Map options
    const options = {
        zoom: 10,
        center: { lat: 12.8754518295616, lng: 80.08377071463102 }
    };

    // Create a new map
    const map = new google.maps.Map(document.getElementById('map'), options);

    // Define the hot spots
    const hotSpots = [
        {
            position: { lat: 12.8754518295616, lng: 80.08377071463102 },
            content: '<h3>BSA CRESCENT INSTITUTE OF SCIENCE AND TECHNOLOGY</h3><p>B.S. Abdur Rahman Crescent Institute of Science and Technology, formerly B. S. Abdur Rahman University, is a private deemed university located in Tamil Nadu, India. Previously, functioning under University of Madras and Anna University as Crescent Engineering College, the institute gained deemed status in 2008–09.</p>'
        },
        {
            position: { lat: 12.880437856002526, lng: 80.08091522517608 },
            content: '<h3>Arignar Anna Zoological Park</h3><p>Arignar Anna Zoological Park, also known as the Vandalur Zoo, is a zoological garden located in Vandalur, Chennai, India, about 31 kilometres from the Chennai Central and 15 kilometres from Chennai Airport. Established in 1855, it is the second public zoo in India.</p>'   
        }
    ];

    // Add markers to the map
    hotSpots.forEach(spot => {
        const marker = new google.maps.Marker({
            position: spot.position,
            map: map
        });

        // Add an info window to each marker
        const infoWindow = new google.maps.InfoWindow({
            content: spot.content
        });

        marker.addListener('click', () => {
            infoWindow.open(map, marker);
        });
    });
}
