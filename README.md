# Appointment Booking System

A simple **Appointment Booking System** built using **Spring Boot**, **PostgreSQL**, and **HTML/CSS**. Users can **create accounts**, **create time slots**, and **book appointments**.

---

## Features

* **User Management**

  * Create new users with username and password
  * List all users

* **Slot Management**

  * Create time slots with date and time
  * View all available slots

* **Booking Management**

  * Book an appointment for a user
  * Link users to available slots

* **Frontend**

  * Simple HTML forms to interact with the system
  * Deployed as a static web page served by Spring Boot

---

## Technologies Used

* **Backend:** Spring Boot, Spring Data JPA
* **Database:** PostgreSQL
* **Frontend:** HTML, CSS
* **Build Tool:** Maven
* **Java Version:** 25

---

## Setup & Installation

1. **Clone the repository**

```bash
git clone https://github.com/your-username/appointment-booking.git
```

2. **Configure PostgreSQL**

   * Create a database named `appointment_db`
   * Update `application.properties` with your PostgreSQL credentials

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/appointment_db
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

3. **Build and run the project**

```bash
mvn clean install
mvn spring-boot:run
```

4. **Access the application**

   * Open your browser and visit: [http://localhost:8080/index.html](http://localhost:8080/index.html)

---

## API Endpoints

* **User**

  * `POST /users` – Create a new user
  * `GET /users` – Get all users
  * `PUT /users/{id}` – Update a user
  * `DELETE /users/{id}` – Delete a user

* **Slot**

  * `POST /slots` – Create a new slot
  * `GET /slots` – Get all slots
  * `PUT /slots/{id}` – Update a slot
  * `DELETE /slots/{id}` – Delete a slot

* **Booking**

  * `POST /bookings` – Book a slot for a user
  * `GET /bookings` – Get all bookings
  * `DELETE /bookings/{id}` – Delete a booking

---

## Future Enhancements

* Add **login authentication** for users
* Add **slot availability checks**
* Improve frontend with **ReactJS or Angular**

---

## Author

**Hemanth Arikotam**

* [LinkedIn]([https://www.linkedin.com/in/arikotamhemanthkumar/])
* [GitHub]([https://github.com/hemanth721y])

---

## License

This project is licensed under the MIT License.
