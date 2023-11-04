package model.domain;

public class Round {

    private final int round;

    public Round(String roundStr) {
        this.round = checkMoreOne(checkIsNumber(roundStr));
    }

    public int getRound() {
        return round;
    }

    private int checkIsNumber(String roundStr) {

        try {
            return Integer.parseInt(roundStr.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }

    private int checkMoreOne(int number) {
        if (number < 1) {
            throw new IllegalArgumentException();
        }

        return number;
    }

}
