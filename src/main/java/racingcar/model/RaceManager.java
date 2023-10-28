package racingcar.model;

public class RaceManager {

    public void validateNumberOfMove(String playerInput) {
        if (toNumber(playerInput) < 0) {
            throw new IllegalArgumentException();
        }
    }

    private int toNumber(String playerInput) {
        try {
            return Integer.parseInt(playerInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
