# 🧭 MakeMyTrip Automation with Selenium

This project automates flight search interactions on [MakeMyTrip](https://www.makemytrip.com/) using Selenium WebDriver in Java. It demonstrates robust XPath construction, dynamic suggestion list handling, and calendar date selection logic.

## 🚀 Features

- Launches Chrome browser in maximized mode
- Closes initial modal popup
- Selects source and destination cities using autosuggest
- Dynamically selects a travel date (5 days from today)
- Uses explicit waits for reliable element interaction

## 🛠️ Tech Stack

- **Language**: Java
- **Automation Framework**: Selenium WebDriver
- **Browser**: Chrome (via ChromeDriver)
- **Build Tool**: Maven or Gradle (optional)
- **Java Time API**: For dynamic date handling

## 📦 Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/makemytrip-automation.git
   cd makemytrip-automation

2. **Install dependencies**
   - Ensure you have Java 11+ installed
   - Download and configure ChromeDriver in your system path

3. **Run the script**
   - Use your IDE or run via terminal
   ```bash
          javac MakeMyTripAutomation.java
          java com.makemytrip.MakeMyTripAutomation
   ```

## 📁 Project Structure
        makemytrip-automation/
        ├── src/
        │   └── com/
        │       └── makemytrip/
        │           └── MakeMyTripAutomation.java
        ├── README.md


## 🧪 Future Enhancements

  - Add return date selection
  - Integrate test assertions for validation
  - Export selected flight details


