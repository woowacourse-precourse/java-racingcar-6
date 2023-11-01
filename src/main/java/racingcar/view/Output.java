package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Messages;

public class Output {
    public static void printStartMessage() {
        System.out.println(Messages
                .START_MESSAGE
                .getMessage());
    }

    public static void printAttemptNumberMessage() {
        System.out.println(Messages
                .ATTEMPT_NUMBER_MESSAGE
                .getMessage());
    }

    public static void printResultMessage() {
        System.out.println(Messages
                .RESULT_MESSAGE
                .getMessage());
    }

    public static void printRacingProgress() {
        List<String> carNames = Car.getNames();

        for (int i=0;i<carNames.size();i++){
            printPlayerScore(carNames, i);
        }

        System.out.println();
    }

    public static void printPlayerScore(List<String> carNames, int index) {
        System.out.print(carNames.get(index) + " : ");
        printDistance(index);
    }

    public static void printDistance(int index) {
        StringBuilder distance = new StringBuilder();
        List<Integer> carMoves = Car.getMoves();

        for (int i = 0; i < carMoves.get(index); i++) {
            distance.append("-");
        }

        System.out.println(distance);
    }

    public static void printWinners(String result) {
        System.out.println(Messages
                .FINAL_WINNER
                .getMessage() + result);
    }
}
