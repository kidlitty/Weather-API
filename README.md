# ☁️ Dynamic Weather Console Application (Java)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Apache HTTPClient](https://img.shields.io/badge/Apache%20HttpClient-D22128?style=for-the-badge&logo=apache&logoColor=white)
![Jackson](https://img.shields.io/badge/Jackson%20JSON-333333?style=for-the-badge&logo=jackson&logoColor=white)
![Visual Crossing API](https://img.shields.io/badge/Visual%20Crossing%20API-4A90E2?style=for-the-badge&logo=weatherapi&logoColor=white)

## Project Overview

This project presents a robust and interactive **Java console application** engineered to fetch and display comprehensive weather data. Leveraging the **Visual Crossing Weather API**, it demonstrates proficiency in **API integration**, **object-oriented design**, **secure credential handling**, and **precise data localization**. This application serves as a practical showcase of core Java development principles applied to real-world data consumption.

---

## ✨ Core Functionality & Demonstrated Skills

* **Robust API Integration:** Seamlessly consumes the Visual Crossing Weather API, translating complex JSON responses into clear, actionable weather insights. This involves:
    * **HTTP Client Management:** Utilizing **Apache HttpClient** for efficient and reliable asynchronous HTTP requests.
    * **JSON Serialization/Deserialization:** Employing **Jackson Databind** for automated mapping of dynamic API payloads to well-structured Java Data Transfer Objects (DTOs).
* **Precision Time Localization:** Implemented advanced time handling using Java's `java.time` API, accurately displaying current weather times in the queried location's specific timezone by leveraging `datetimeEpoch` and `ZoneId` for unparalleled precision.
* **Flexible Unit System:** Empowered user experience with a **user-driven unit selection** feature, allowing dynamic display of temperature (°C/°F), wind speed (km/h/mph), and pressure (hPa/mb) based on user preference (`metric` or `us` unit groups).
* **Secure Credential Management:** Designed for enhanced security by prompting for the Visual Crossing API key at **runtime**, preventing sensitive data from being hardcoded or committed to version control.
* **Structured Data Modeling (DTOs):** Developed a clear and maintainable DTO layer (`WeatherResponse`, `CurrentConditions`, `Day`, `Hour`) to encapsulate API response structures, promoting **clean code** and **separation of concerns**.
* **Resilient Error Handling:** Incorporated defensive programming and comprehensive exception handling for graceful management of API communication issues, network problems, and invalid user inputs.

---

## 🛠️ Technology Stack

* **Core Language:** Java (JDK 11+)
    * Leveraging modern Java features and the `java.time` API for date/time handling.
* **Build Automation:** Apache Maven
    * Manages project dependencies and standardizes the build lifecycle.
* **HTTP Client:** Apache HttpClient
    * Provides robust and efficient capabilities for making external API calls.
* **JSON Processing:** Jackson Databind (`com.fasterxml.jackson.core`)
    * Chosen for its high performance and flexibility in mapping complex JSON structures to Java Objects.

---

## 🏗️ Project Structure & Design Principles

The application adheres to a clear architectural separation of concerns:

* `WeatherApp.java`: The main application entry point responsible for command-line interface (CLI) interaction, user input handling, and orchestrating calls to the `WeatherService`.
* `WeatherService.java`: Encapsulates all external API communication logic. It constructs API requests, handles HTTP responses, and leverages Jackson for JSON deserialization, effectively isolating API interaction from the core application flow.
* `DTOs/` (`WeatherResponse.java`, `CurrentConditions.java`, `Day.java`, `Hour.java`): A dedicated package for Data Transfer Objects, mirroring the structure of the Visual Crossing API's JSON responses. These classes utilize `@JsonIgnoreProperties(ignoreUnknown = true)` for forward compatibility and robustness against API changes.

This design promotes modularity, testability, and maintainability, aligning with **Object-Oriented Programming (OOP)** best practices.

---

## 🚀 How to Run the Application

### Prerequisites

* **Java Development Kit (JDK):** Version 11 or higher.
* **Apache Maven:** Ensure Maven is installed and configured in your system's PATH.
* **An IDE (Integrated Development Environment):** IntelliJ IDEA, Eclipse, or VS Code with Java extensions are recommended.

### Get Your Visual Crossing API Key

1.  Navigate to the [Visual Crossing Weather API website](https://www.visualcrossing.com/weather-api).
2.  Sign up for a free account.
3.  Your API key will be available on your account dashboard after registration. Keep this key handy.

### Setup and Execution Steps

1.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/YOUR_GITHUB_USERNAME/YOUR_REPO_NAME.git](https://github.com/YOUR_GITHUB_USERNAME/YOUR_REPO_NAME.git)
    cd YOUR_REPO_NAME
    ```
    *(**Note:** Replace `YOUR_GITHUB_USERNAME` and `YOUR_REPO_NAME` with your actual GitHub username and the name of your repository.)*

2.  **Build the Project:**
    Open your terminal, navigate to the project's root directory (where `pom.xml` is located), and execute the Maven build command:
    ```bash
    mvn clean install
    ```
    This command will download all necessary dependencies and compile the project into an executable JAR.

3.  **Run the Application:**
    From the same directory, launch the application:
    ```bash
    mvn exec:java -Dexec.mainClass="com.weatherapi.WeatherApp"
    ```
    *(Confirm that `com.weatherapi.WeatherApp` correctly reflects the package and class name of your main application entry point.)*

4.  **Interactive Prompts:**
    Upon execution, the application will guide you through:
    * Entering your **Visual Crossing API Key**.
    * Selecting your preferred **unit system** (e.g., `C` for Celsius/Metric, `F` for Fahrenheit/US).
    * Choosing between a 15-day forecast or current conditions for your specified location.

---

## 📈 Opportunities for Growth

This project serves as a solid foundation for further development. Potential enhancements include:

* **Advanced Data Visualization:** Integrating a graphical user interface (GUI) or charting library to visualize weather trends.
* **Configuration Management:** Implementing external configuration files for API keys and default settings, allowing for easier deployment and environment management.
* **Comprehensive Input Validation:** Enhancing user input validation to cover edge cases and provide more specific feedback.
* **Asynchronous API Calls:** Exploring asynchronous programming (e.g., CompletableFuture) for improved responsiveness during network operations.
* **Unit & Integration Testing:** Developing a robust suite of tests to ensure code reliability and API integration correctness.

---

## 📄 License

This project is open-source and available under the **MIT License**. See the `LICENSE` file for full details.

---

## 📞 Contact

Feel free to connect or ask questions about this project:

* **Name:** Uphile Ntuli
* **GitHub:** https://github.com/kidlitty

https://roadmap.sh/projects/weather-api-wrapper-service
---