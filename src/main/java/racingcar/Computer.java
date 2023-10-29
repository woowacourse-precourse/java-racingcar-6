package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Computer {
    public static String getInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public static List<String> createCarNames(String userInput) {
        return Arrays.asList(userInput.split(","));
    }

    public static int calculateMaxDistance(Car car) {
        int maxDistance = 0;

        for (int i = 0; i < car.names.size(); i++) {

            if (maxDistance <= car.movedDistances.get(i).length()) {
                maxDistance = car.movedDistances.get(i).length();
            }

        }

        return maxDistance;
    }

    public static StringJoiner findWinner(Car car, int maxDistance) {
        System.out.print("최종 우승자 : ");
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

    public static int createRoundCount(String userInput) {
        Validator.checkPositiveNumber(userInput);
        return Integer.parseInt(userInput);
    }
}
