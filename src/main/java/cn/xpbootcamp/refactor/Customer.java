package cn.xpbootcamp.refactor;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String name;
    private Vector<Rental> rentals = new Vector<>();

    Customer(String name) {
        this.name = name;
    }

    void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    String statement() {
        StringBuilder result = addHeader();
        result.append(addBody());
        result.append(addFooter());
        return result.toString();
    }

    private String  addFooter() {
        StringBuilder result = new StringBuilder();
        result.append("Amount owed is ").append(calculateTotalAmount()).append("\n");
        result.append("You earned ").append(calculateFrequentRenterPoints()).append(" frequent renter points");
        return result.toString();
    }

    private String addBody() {
        StringBuilder result = new StringBuilder();
        for (Rental rental : this.rentals) {
            result.append("\t")
                  .append(rental.getMovie().getTitle())
                  .append("\t")
                  .append(rental.getAmount()).append("\n");
        }
        return result.toString();
    }

    private StringBuilder addHeader() {
        return new StringBuilder("Rental Record for " + getName() + "：\n");
    }

    private double calculateTotalAmount() {
        double totalAmount = 0d;
        for (Rental rental : this.rentals) {
            totalAmount += rental.getAmount();
        }
        return totalAmount;
    }

    private int calculateFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : this.rentals) {
            frequentRenterPoints = frequentRenterPoints + rental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

}
