# ⏰ Scheduled Report Generator (Spring Boot + Cron Jobs)

A simple **Java 21 + Spring Boot** project that demonstrates how to use **cron jobs / task scheduling** to automate recurring tasks.

In this example, a daily job runs at **8 AM** to generate a summary report of all notes and (simulated) **send it via email** to users.

---

## 🚀 Features

* **Spring Boot 3 + Java 21**
* **Task Scheduling** with `@Scheduled`
* **Cron Expression** for flexible scheduling
* **Spring Data JPA** with PostgreSQL
* Simple **Note entity & repository**
* **Daily Report Job** that runs automatically

---

## 🛠️ Tech Stack

* Java 21
* Spring Boot 3+
* Spring Data JPA
* PostgreSQL
* Maven

---

## 📂 Project Structure

```
scheduled-reports/
├── src/main/java/com/example/notes
│   ├── NotesApplication.java        # Entry point
│   ├── entity/Note.java             # Entity
│   ├── repository/NoteRepository.java
│   └── scheduler/ReportScheduler.java  # Cron job logic
├── src/main/resources/
│   ├── application.yml              # DB configuration
└── pom.xml
```

---

## ⚙️ Setup & Run

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/scheduled-reports.git
cd scheduled-reports
```

### 2. Create PostgreSQL Database

```sql
CREATE DATABASE notesdb;
```

### 3. Update Configuration

Edit `src/main/resources/application.yml` with your PostgreSQL credentials:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/notesdb
    username: postgres
    password: password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

### 4. Run the App

```bash
mvn spring-boot:run
```

---

## 🔄 Cron Job Configuration

The scheduler is defined in `ReportScheduler.java`:

```java
@Scheduled(cron = "0 0 8 * * ?") // Runs daily at 8 AM
public void generateDailyReport() {
    ...
}
```

* **Format:** `second minute hour day-of-month month day-of-week`
* Example:

  * `0 0 8 * * ?` → Every day at 8 AM
  * `0 * * * * ?` → Every minute (useful for demo/testing)

---

## 📌 Sample Output

When the job runs, you’ll see logs like:

```
=== Daily Report (2025-09-18T08:00:00) ===
Total notes: 3
 - Meeting Notes
 - Shopping List
 - Project Plan
✅ Report sent to users successfully!
```

---

## 🎯 Interview Talking Points

* **How it works**: Used Spring’s `@Scheduled` annotation with a cron expression.
* **Why it’s useful**: Automates recurring tasks (e.g., reports, cleanups, email reminders).
* **Impact**: Reduces manual effort, ensures consistency, improves efficiency.
* **Reliability**: Added logging and error handling for monitoring and debugging.

---

## 📜 License

This project is licensed under the MIT License.

---
