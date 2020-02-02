package models;

public class RoundedSum {

    private int value;

    public RoundedSum(double amount) {
        int convertedToInt = (int) amount;
        value = ((convertedToInt + 99) / 100 ) * 100;
    }

    public int getValue() {
        return value;
    }
}
