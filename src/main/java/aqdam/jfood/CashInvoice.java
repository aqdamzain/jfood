package aqdam.jfood;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CashInvoice extends Invoice {
    private final static PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee;

    public CashInvoice(int id, ArrayList<Food> foods, Customer customer) {
        super(id, foods, customer);
    }

    public CashInvoice(int id, ArrayList<Food> food, Customer customer, int deliveryFee) {
        super(id, food, customer);
        this.deliveryFee = deliveryFee;
    }

    @Override
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;
    }

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(int deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    @Override
    public void setTotalPrice() {
        if (!(deliveryFee == 0)) {
            for (Food food : super.getFoods()) {
                super.totalPrice = super.totalPrice + food.getPrice();
            }
            super.totalPrice = super.totalPrice + deliveryFee;
        } else {
            for (Food food : super.getFoods()) {
                super.totalPrice = super.totalPrice + food.getPrice();
            }
        }

    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String nameFoods = "";
        for (Food food : super.getFoods()) {
            nameFoods = nameFoods + food.getName() + ", ";
        }
        String string = "\n=========== INVOICE ===========" +
                "\nID: " + super.getId() + "\nFood: " + nameFoods + "\nDate: " + dateFormat.format(super.getDate().getTime()) + "\nCustomer: " + super.getCustomer().getName()
                + "\nDelivery Fee: " + this.deliveryFee + "\nTotal Price: " + super.totalPrice + "\nPayment Type: " + PAYMENT_TYPE + "\nInvoice Status: " + super.getInvoiceStatus() + "\n";

        return string;
    }
}
