package com.usbvalidator.controller;

import com.usbvalidator.service.PowerShellDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeviceController {

    @Autowired
    private PowerShellDeviceService powerShellDeviceService;

    @GetMapping("/devices")
    public List<PowerShellDeviceService.UsbDeviceInfo> getDevices() {
        return powerShellDeviceService.getUsbDeviceDetails();
    }
}