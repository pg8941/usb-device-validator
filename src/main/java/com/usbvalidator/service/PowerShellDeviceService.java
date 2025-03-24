package com.usbvalidator.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class PowerShellDeviceService {

    public static class UsbDeviceInfo {
        private String status;
        private String friendlyName;
        private String instanceId;

        public UsbDeviceInfo(String status, String friendlyName, String instanceId) {
            this.status = status;
            this.friendlyName = friendlyName;
            this.instanceId = instanceId;
        }

        public String getStatus() {
            return status;
        }

        public String getFriendlyName() {
            return friendlyName;
        }

        public String getInstanceId() {
            return instanceId;
        }
    }

    public List<UsbDeviceInfo> getUsbDeviceDetails() {
        List<UsbDeviceInfo> deviceDetails = new ArrayList<>();
        try {
            ProcessBuilder pb = new ProcessBuilder("powershell", "Get-PnpDevice -Class USB");
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            boolean dataStart = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("FriendlyName")) {
                    dataStart = true;
                }
                if (dataStart && !line.contains("FriendlyName") && !line.contains("------") && !line.contains("Status")) {
                    String[] parts = line.trim().split("\\s{2,}"); // Split by 2 or more spaces
                    if (parts.length >= 3) {
                        deviceDetails.add(new UsbDeviceInfo(parts[0], parts[2], parts[3]));
                    }
                }
            }
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deviceDetails;
    }
}