# Currency Converter
### Table of Contents
- [About The Project](#about-the-project)
  - [Built With](#built-with)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
  - [Examples](#examples)

<!-- ABOUT THE PROJECT -->
## About The Project

<div align="center" padding="20">
<img src="https://cdn.glitch.global/25528f5b-58e5-4224-ae4c-5f2f3f710606/022811dd-28ec-433a-a00b-085bd30b4882.jpg?v=1734025522052" alt="currency converter background" height="250px" >
</div>
This project is designed to simplify currency conversions by using an API to fetch the latest exchange rates. With user-friendly input validation and an intuitive menu, the program ensures seamless currency conversion while maintaining code modularity and scalability.

<b>Key Features</b>:
- Predefined and custom currency conversions.
- Real-time exchange rate fetching using HTTP requests.
- Input validation to ensure accurate and error-free user interaction.
- Error handling for invalid inputs and API communication issues.

### Built With

- **Java 17**: Main programming language.
- **Gson**: JSON parsing library for handling API responses.
- **HttpClient**: Java's built-in library for making HTTP requests.

<!-- GETTING STARTED -->
## Getting Started
To get a local copy up and running, follow these simple steps.

### Prerequisites
Ensure you have the following installed on your system:
- Java Development Kit (JDK) 17 or higher
- Maven for dependency management
- Get a free API Key at [ExchangeRate API](https://www.exchangerate-api.com/)

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repository/currency-converter.git
   ```
2. Navigate to the project directory:
   ```bash
   cd currency-converter
   ```
3. Install dependencies using Maven:
   ```bash
   mvn install
   ```
4. Build the project:
   ```bash
   mvn package
   ```

## Usage
1. Run the program:
   ```bash
   java -jar target/currency-converter.jar
   ```
2. Follow the on-screen menu to select your desired conversion option.
3. Enter the required details (amount and currencies) as prompted.
4. View the converted amount and repeat the process as needed.

---
### Examples:
- <b>Option 1:</b> Convert USD to PEN.
<img src="https://github.com/abengl/Alura-Conversor-Monedas/blob/30e3065227b9cc0e29adda8678c0d4599b130b07/src/main/resources/CC-options.png" alt="currency converter option" height="250px" >
- <b>Option 6:</b> Enter custom currency codes, e.g., PEN to KRW.
<img src="https://github.com/abengl/Alura-Conversor-Monedas/blob/30e3065227b9cc0e29adda8678c0d4599b130b07/src/main/resources/CC-custom.png" alt="currency converter custom" height="250px" >
- <b>Errors:</b> When an invalid input is entered an error will appear and the user will be prompted to start the process again.
<img src="https://github.com/abengl/Alura-Conversor-Monedas/blob/30e3065227b9cc0e29adda8678c0d4599b130b07/src/main/resources/CC-error.png" alt="currency converter error" height="250px" >



