document.addEventListener("DOMContentLoaded", function () {
    const theaterSeating = document.getElementById('theaterSeating');
    const selectedSeatsDisplay = document.getElementById('selectedSeatsDisplay');

    // Generate dummy seating arrangement
    for (let i = 1; i <= 10; i++) { // 10 rows
        const row = document.createElement('div');
        row.className = 'row';
        for (let j = 1; j <= 10; j++) { // 10 seats per row
            const seat = document.createElement('div');
            seat.className = 'seat';
            seat.textContent = `${i}-${j}`;
            seat.addEventListener('click', function () {
                seat.classList.toggle('selected');
                updateSelectedSeats();
            });
            row.appendChild(seat);
        }
        theaterSeating.appendChild(row);
    }

    function updateSelectedSeats() {
        const selectedSeats = document.querySelectorAll('.seat.selected');
        const selectedSeatNumbers = Array.from(selectedSeats).map(seat => seat.textContent);
        selectedSeatsDisplay.textContent = selectedSeatNumbers.join(', ');
    }

    // Handle MobilePay button click (placeholder action)
    const mobilePayButton = document.getElementById('mobilePayButton');
    mobilePayButton.addEventListener('click', function () {
        alert('Payment processed with MobilePay for seats: ' + selectedSeatsDisplay.textContent);
        // Here, you could implement the actual payment logic
    });
});
