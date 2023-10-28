package racingcar.model;

import java.util.List;

public class RaceManager {

    private static int numberOfMove;

    public static void validateNumberOfMove(String numberOfMove) {
        int number = toNumber(numberOfMove);
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        RaceManager.numberOfMove = number;
    }

    public static void startRace(List<Car> cars) {

    }

    private static int toNumber(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
