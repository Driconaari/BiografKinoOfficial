document.addEventListener("DOMContentLoaded", function () {
    fetchMovies(); // Fetch the list of movies on page load

    // Handle Buy Tickets button click
    const buyTicketsButton = document.getElementById('buyTicketsButton');
    buyTicketsButton.addEventListener('click', redirectToPurchasePage);
});

function fetchMovies() {
    fetch('/api/movies')
        .then(response => response.json())
        .then(movies => {
            const movieList = document.getElementById('movieList');
            movieList.innerHTML = ''; // Clear existing content
            movies.forEach(movie => {
                const listItem = document.createElement('li');
                listItem.innerHTML = `
                    <h3>${movie.title}</h3>
                    <p>Release Date: ${new Date(movie.release_date).toLocaleDateString()}</p>
                    <p>Rating: ${movie.rating}</p>
                    <p>Length: ${movie.length} mins</p>
                    <p>Genre: ${movie.genre}</p>
                    <p>Age Limit: ${movie.age_limit}</p>
                `;
                movieList.appendChild(listItem);
            });
        })
        .catch(error => console.error('Error fetching movies:', error));
}

function redirectToPurchasePage() {
    window.location.href = '/api/buy-tickets'; // Redirect to the purchase page
}
