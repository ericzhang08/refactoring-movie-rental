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
        double totalAmount = 0d;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "：\n");
        for (Rental each : this.rentals) {
            //show figures for this rental
            //determine amounts for each line
            double thisAmount = each.getAmount();

            //add frequent renter points
            frequentRenterPoints = frequentRenterPoints + each.getFrequentRenterPoints();

            //show figures for this rental
            result.append("\t")
                  .append(each.getMovie().getTitle())
                  .append("\t")
                  .append(thisAmount).append("\n");
            totalAmount += thisAmount;
        }
        //add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }

}
