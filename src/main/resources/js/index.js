document.addEventListener("DOMContentLoaded", function () {
    let currentPage = 0;
    const pageSize = 10;

    fetchMovies(currentPage, pageSize);

    const nextPageButton = document.getElementById('nextPageButton');
    const prevPageButton = document.getElementById('prevPageButton');
    const searchButton = document.getElementById('searchButton');
    const searchInput = document.getElementById('searchInput');

    nextPageButton.addEventListener('click', () => {
        currentPage++;
        fetchMovies(currentPage, pageSize, searchInput.value);
    });

    prevPageButton.addEventListener('click', () => {
        if (currentPage > 0) {
            currentPage--;
            fetchMovies(currentPage, pageSize, searchInput.value);
        }
    });

    searchButton.addEventListener('click', () => {
        currentPage = 0;
        fetchMovies(currentPage, pageSize, searchInput.value);
    });

    const buyTicketsButton = document.getElementById('buyTicketsButton');
    buyTicketsButton.addEventListener('click', redirectToPurchasePage);
});

function fetchMovies(page, size, search = '') {
    fetch(`/api/movies?page=${page}&size=${size}&search=${search}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            const movies = data.content;
            const movieList = document.getElementById('movieList');
            movieList.innerHTML = '';
            movies.forEach(movie => {
                const listItem = document.createElement('li');
                listItem.textContent = `${movie.title} - ${movie.release_date} - Rating: ${movie.rating}`;
                movieList.appendChild(listItem);
            });
        })
        .catch(error => console.error('Error fetching movies:', error));
}

function redirectToPurchasePage() {
    window.location.href = '/api/buy-tickets';
}