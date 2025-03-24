# usb-device-validator

**USB Device Validation System**

**1. Introduction:**

This report details the development and implementation of the "USB Device Validation System," a Spring Boot application designed to provide a user-friendly interface for inspecting and testing connected USB devices on a Windows platform.
**2. Why Needed:**

In the realm of USB device development and testing, particularly within a large ecosystem like Samsung's, the need for a reliable and accessible tool to analyze connected devices is paramount. Current methods often involve complex command-line utilities or require specialized hardware. This project addresses the need for a simplified, web-based solution that:

Reduces the learning curve for device inspection.
Provides a centralized platform for device information.
Enables rapid identification of device issues.
Aids in debugging and validation processes.

**3. What It Does:**

The USB Device Validation System provides the following functionalities:

Device Listing: Displays a list of connected USB devices with their status, friendly names, and instance IDs.
Device Details: Retrieves detailed information about a selected device, including manufacturer and hardware IDs.
Data Transfer Test: Performs a basic data transfer test to assess USB drive performance.
Power Information Display: Shows USB hub power management capabilities.
UI toggle: Provides a pretty print checkbox that toggles between json and table view.

**4. Tech Stack:**

Backend:
Spring Boot (Java): For building the RESTful API and handling server-side logic.
PowerShell: For interacting with the Windows operating system and retrieving device information.
Frontend:
HTML, CSS, JavaScript: For creating the user interface.
Fetch API: for getting json data.
Dependencies:
usb-api: javax.usb api
usb4java-javax: usb4java implementation of javax.usb.

**5. Tools:**

Spring Tool Suite (STS): For Java development.
Git/GitHub: For version control and collaboration.
Postman: Api testing.

**6. Technologies:**

RESTful APIs
PowerShell scripting
JSON data serialization/deserialization
Java/Springboot
Javascript

**7. Challenges:**

PowerShell Integration: Ensuring seamless integration between Java and PowerShell, handling output parsing, and managing potential security risks.
Cross-Platform Limitations: The solution is inherently Windows-specific, limiting its portability.
Data Accuracy: Relying on PowerShell for data transfer testing introduces potential inaccuracies.
Libusb issues: Libusb is very low level and requires correct setup, and can cause issues with the javax.usb api.

**8. Future Scope:**

Enhanced Device Information: Integrate with native libraries (like libusb) or Windows APIs to retrieve more detailed device information.
Automated Testing: Implement automated testing routines for USB devices, such as performance benchmarks and compliance checks.
Cross-Platform Support: Explore options for cross-platform compatibility, potentially using libusb or other platform-independent libraries.
Real-Time Monitoring: Implement real-time device monitoring and event logging.
UI improvements: Add more filters, search bars, and improve the overall look and feel of the UI.
Error Handling: Implement better error handling and logging.

**9. What's New from Present:**

This system streamlines the device validation process by providing a web-based interface that eliminates the need for complex command-line operations. It consolidates device information and testing tools into a single platform, enhancing efficiency and accessibility.

**10. Input and Output:**

Input:
User interaction through the web UI (e.g., selecting a device, triggering a test).
File path for data transfer test.
Output:
JSON data representing device information.
Table view of device details in the UI.
Results of data transfer tests.
Alert boxes with device details.

**11. Use Cases:**

Device Validation: Verifying the functionality and compatibility of USB devices during development and testing.
Troubleshooting: Identifying and diagnosing issues with connected USB devices.
Performance Testing: Assessing the data transfer capabilities of USB drives.
Reporting: Generating reports of connected devices and test results.

**12. Daily Life Use (Samsung USB Framework Team):**

As a member of the Samsung USB Framework Team, this tool can:

Speed up the device validation process, reducing the time spent on manual testing.
Provide a centralized platform for device information, facilitating collaboration among team members.
Aid in debugging and troubleshooting by providing detailed device information and test results.
Help ensure compatibility and compliance of Samsung USB devices.

**13. User Point of View:**

From a user perspective, this tool offers a user-friendly way to inspect and test connected USB devices. It simplifies the process of retrieving device information and performing basic tests, making it accessible to both technical and non-technical users.

**14. Code Snippets (Examples):**

Java (PowerShellDeviceService.java):
Java

public List<UsbDeviceInfo> getUsbDeviceDetails() {
    // ... (PowerShell execution and parsing)
}
JavaScript (script.js):
JavaScript

fetch('/devices')
    .then(response => response.json())
    .then(devices => {
        // ... (UI update logic)
    });


**15. Diagrams and Structure:**

**Architecture Diagram:**
[Browser (UI)] <--> [Spring Boot (REST API)] <--> [PowerShell (Device Info)]
Project Structure:
usb-device-validator/
├── src/main/java/com/usbvalidator/
│   ├── controller/
│   │   └── DeviceController.java
│   ├── service/
│   │   └── PowerShellDeviceService.java
│   └── UsbDeviceValidatorApplication.java
├── src/main/resources/
│   ├── static/
│   │   ├── index.html
│   │   └── script.js
│   └── application.properties
├── pom.xml
└── README.md
**16. Result Part:**

The project successfully delivers a functional web-based USB device validation system. The UI displays connected devices, and the device details function provides extra information. The data transfer test provides rough estimates of transfer speeds.

**17. Testing Results:**

Unit tests for Java services (PowerShell execution and parsing).
Integration tests for RESTful APIs.
Manual testing for UI functionality and data accuracy.
Testing on multiple usb devices.
