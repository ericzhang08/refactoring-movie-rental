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

        int frequentRenterPoints = calculateFrequentRenterPoints();

        double totalAmount = calculateTotalAmount();

        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "：\n");
        for (Rental rental : this.rentals) {
            result.append("\t")
                  .append(rental.getMovie().getTitle())
                  .append("\t")
                  .append(rental.getAmount()).append("\n");
        }
        //add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
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
