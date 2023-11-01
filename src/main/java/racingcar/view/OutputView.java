package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;

import static racingcar.utils.Constants.RESULT;

public class OutputView {

    public static void printResultMessage() {
        System.out.println(RESULT.getValue());
    }

    public static String printProgress(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public static void printResultPerAttempt(ArrayList<Car> result) {
        for (Car car : result) {
            System.out.printf("%s : %s%n", car.getName(), printProgress(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinner(String[] winners) {
        String finalWinners = String.join(", ", winners);
        System.out.printf("최종 우승자 : %s%n", finalWinners);
    }
}
