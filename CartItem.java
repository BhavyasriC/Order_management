package com;
public class CartItem {
    private int cartId;
    private int customerId;
    private int productCode;
    private int quantity;
    
    public CartItem() {
    }
    
    public CartItem(int customerId, int productCode, int quantity) {
        this.customerId = customerId;
        this.productCode = productCode;
        this.quantity = quantity;
    }



    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart [cartId=" + cartId + 
               ", customerId=" + customerId + 
               ", productCode=" + productCode + 
               ", quantity=" + quantity + "]";
    }
}
