function createUser() {
    fetch('/users', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            username: document.getElementById('username').value,
            password: document.getElementById('password').value
        })
    })
    .then(res => res.json())
    .then(data => {
        document.getElementById('result').innerText =
            "User created with ID: " + data.id;
    });
}

function createSlot() {
    fetch('/slots', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            slotDate: document.getElementById('date').value,
            slotTime: document.getElementById('time').value
        })
    })
    .then(res => res.json())
    .then(data => {
        document.getElementById('result').innerText =
            "Slot created with ID: " + data.id;
    });
}

function bookAppointment() {
    let userId = document.getElementById('userId').value;
    let slotId = document.getElementById('slotId').value;

    fetch(`/bookings?userId=${userId}&slotId=${slotId}`, {
        method: 'POST'
    })
    .then(res => res.json())
    .then(data => {
        document.getElementById('result').innerText =
            "Appointment booked successfully (ID: " + data.id + ")";
    });
}
