const prettyPrintCheckbox = document.getElementById('prettyPrint');
const jsonView = document.getElementById('jsonView');
const deviceList = document.getElementById('deviceList');
const updateButton = document.getElementById('updateButton');

function updateDisplay() {
    fetch('/devices')
        .then(response => response.json())
        .then(devices => {
            if (prettyPrintCheckbox.checked) {
                jsonView.style.display = 'block';
                deviceList.style.display = 'none';
                jsonView.textContent = JSON.stringify(devices, null, 2); // Pretty print JSON
            } else {
                jsonView.style.display = 'none';
                deviceList.style.display = 'block';
                let table = '<table><thead><tr><th>Status</th><th>Friendly Name</th><th>Instance ID</th></tr></thead><tbody>';
                devices.forEach(device => {
                    table += `<tr><td>${device.status}</td><td>${device.friendlyName}</td><td>${device.instanceId}</td></tr>`;
                });
                table += '</tbody></table>';
                deviceList.innerHTML = table;
            }
        });
}

updateButton.addEventListener('click', updateDisplay);

updateDisplay(); // Initial display