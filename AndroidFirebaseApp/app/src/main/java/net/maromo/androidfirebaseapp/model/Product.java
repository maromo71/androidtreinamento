package net.maromo.androidfirebaseapp.model;

import androidx.annotation.NonNull;

public class Product {
    private String productId;
    private String productName;
    private double productPrice;
    private boolean isActive;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return productId.equals(product.productId);
    }

    @Override
    public int hashCode() {
        return (int) (Long.parseLong(productId) ^ ((Long.parseLong(productId) >>> 32)));
    }

    @NonNull
    @Override
    public String toString() {
        return productName;
    }
}
