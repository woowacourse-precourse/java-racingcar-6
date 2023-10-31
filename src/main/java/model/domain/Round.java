package model.domain;

public class Round {

    private int round;

    public Round(String roundStr) {
        this.round = checkIsNumber(roundStr);
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
}
