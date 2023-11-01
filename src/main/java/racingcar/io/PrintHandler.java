package racingcar.io;

import static racingcar.constant.RacingGameMessage.FINAL_WINNER_SENTENCE;
import static racingcar.constant.RacingGameMessage.FINAL_WINNER_SEPARATOR;
import static racingcar.constant.RacingGameMessage.INPUT_CAR_NAMES_PROMPT;
import static racingcar.constant.RacingGameMessage.INPUT_TRIAL_NUMBER_PROMPT;
import static racingcar.constant.RacingGameMessage.RESULT_LOCATION_EXPRESSION;
import static racingcar.constant.RacingGameMessage.RESULT_RUNNING_SENTENCE;
import static racingcar.constant.RacingGameMessage.RESULT_SEPARATOR;

import racingcar.car.Car;
import java.util.List;

public class PrintHandler {
    public static void inputCarNamesPrompt() {
        System.out.println(INPUT_CAR_NAMES_PROMPT);
    }

    public static void inputTrialNumberPrompt() {
        System.out.println(INPUT_TRIAL_NUMBER_PROMPT);
    }

    public static void resultRunningSentence() {
        System.out.println("\n" + RESULT_RUNNING_SENTENCE);
    }

    public static void finalWinnerSentence() {
        System.out.print(FINAL_WINNER_SENTENCE);
    }

    public static void resultRunning(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf(car.getName() + RESULT_SEPARATOR);
            printLocation(car.getLocation());
            System.out.println();
        }
        System.out.println();
    }

    public static void finalWinner(List<String> winnerNames) {
        for (int i = 0; i < winnerNames.size(); i++) {
            if (i == winnerNames.size()-1) {
                System.out.print(winnerNames.get(i));
            } else if (i != winnerNames.size()-1) {
                System.out.print(winnerNames.get(i) + FINAL_WINNER_SEPARATOR);
            }
        }
    }

    private static void printLocation(int location) {
        for (int i = 0; i < location; i++) {
            System.out.print(RESULT_LOCATION_EXPRESSION);
        }
    }
}
