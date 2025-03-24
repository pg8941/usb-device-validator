package com.usbvalidator.model;

public class UsbDevice {
    private String vendorId;
    private String productId;

    public UsbDevice() {}

    public UsbDevice(String vendorId, String productId) {
        this.vendorId = vendorId;
        this.productId = productId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}