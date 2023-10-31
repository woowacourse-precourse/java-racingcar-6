package racingcar;

import static racingcar.Message.RESULT;

import java.util.List;
import java.util.StringJoiner;

public class CarRace {

    public static int createRound(String userInput) {
        Validator.checkNumber(userInput);
        return Integer.parseInt(userInput);
    }

    public static int findBest(List<String> movedDistances) {
        int maxDistance = 0;

        for (int i = 0; i < movedDistances.size(); i++) {

            if (maxDistance <= movedDistances.get(i).length()) {
                maxDistance = movedDistances.get(i).length();
            }

        }

        return maxDistance;
    }

    public static StringJoiner findWinner(Car car, int maxDistance) {
        System.out.print(RESULT.getMessage());
        StringJoiner winner = new StringJoiner(", ");

        for (int i = 0; i < car.names.size(); i++) {

            if (maxDistance == car.movedDistances.get(i).length()) {
                winner.add(car.names.get(i));
            }

        }

        return winner;
    }

    public static void printWinner(StringJoiner winner) {
        System.out.println(winner);
    }
}
