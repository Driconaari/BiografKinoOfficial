// admin-dashboard.js
document.addEventListener("DOMContentLoaded", function () {
    const searchButton = document.getElementById('searchButton');
    const prevPageButton = document.getElementById('prevPageButton');
    const nextPageButton = document.getElementById('nextPageButton');
    const searchInput = document.getElementById('searchInput');

    let currentPage = 0; // Initialize current page
    const pageSize = 10; // Number of movies per page

    // Fetch movies initially
    fetchMovies(currentPage, searchInput.value);

    searchButton.addEventListener('click', function () {
        fetchMovies(0, searchInput.value); // Reset to the first page on search
    });

    prevPageButton.addEventListener('click', function () {
        if (currentPage > 0) {
            currentPage--;
            fetchMovies(currentPage, searchInput.value);
        }
    });

    nextPageButton.addEventListener('click', function () {
        currentPage++;
        fetchMovies(currentPage, searchInput.value);
    });

    function fetchMovies(page, search) {
        fetch(`/api/movies?page=${page}&size=${pageSize}&search=${search}`)
            .then(response => response.json())
            .then(data => {
                const movieList = document.getElementById('movieList');
                movieList.innerHTML = ''; // Clear current movie list

                data.content.forEach(movie => {
                    const listItem = document.createElement('li');
                    listItem.innerHTML = `${movie.title} - ${new Date(movie.release_date).toLocaleDateString()} - ${movie.rating} 
                        <a href="/admin/movies/edit/${movie.id}">Edit</a>
                        <form action="/admin/movies/delete/${movie.id}" method="post" style="display:inline;">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            <button type="submit">Delete</button>
                        </form>`;
                    movieList.appendChild(listItem);
                });
            })
            .catch(error => console.error('Error fetching movies:', error));
    }
});
