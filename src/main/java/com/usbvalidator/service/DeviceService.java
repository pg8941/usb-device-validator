package com.usbvalidator.service;

import com.usbvalidator.model.UsbDevice;
import org.springframework.stereotype.Service;

import javax.usb.UsbDeviceDescriptor;
import javax.usb.UsbServices;
import javax.usb.UsbHub;
import javax.usb.UsbException;
import javax.usb.UsbHostManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {

    public List<UsbDevice> getConnectedDevices() throws UsbException {
        UsbServices services = UsbHostManager.getUsbServices();
        UsbHub rootHub = services.getRootUsbHub();
        return getDevices(rootHub);
    }

    @SuppressWarnings("unchecked")
    private List<UsbDevice> getDevices(UsbHub hub) throws UsbException {
        List<UsbDevice> result = new ArrayList<>();
        List<javax.usb.UsbDevice> attachedDevices = hub.getAttachedUsbDevices();

        for (javax.usb.UsbDevice device : attachedDevices) {
            try {
                UsbDeviceDescriptor descriptor = device.getUsbDeviceDescriptor();
                UsbDevice usbDevice = new UsbDevice(String.format("0x%04X", descriptor.idVendor()), String.format("0x%04X", descriptor.idProduct()));
                result.add(usbDevice);
                System.out.println("Device Found: Vendor ID = " + usbDevice.getVendorId() + ", Product ID = " + usbDevice.getProductId());

                if (device.isUsbHub()) {
                    result.addAll(getDevices((UsbHub) device));
                }
            } catch (UsbException e) {
                System.err.println("Error processing device: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return result;
    }
}