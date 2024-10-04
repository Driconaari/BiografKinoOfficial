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
            movieList.innerHTML = '';
            movies.forEach(movie => {
                const listItem = document.createElement('li');
                listItem.textContent = `${movie.title} - ${movie.releaseDate}`;
                movieList.appendChild(listItem);
            });
        })
        .catch(error => console.error('Error fetching movies:', error));
}

function redirectToPurchasePage() {
    window.location.href = '/api/buy-tickets'; // Redirect to the purchase page
}
