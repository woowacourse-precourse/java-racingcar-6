package racingcar;

import racingcar.Car;

import java.util.List;

public class OutputView {

    public static void printCurrentPosition(Car car) {
        System.out.println(car.getName() + " : " + getPositionString(car.getPosition()));
    }

    public static void printNewLine() {;
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        StringBuilder winnerNames = new StringBuilder();
        for (Car car : winners) {
            winnerNames.append(car.getName()).append(", ");
        }
        winnerNames.delete(winnerNames.length() - 2, winnerNames.length());
        System.out.println("최종 우승자: " + winnerNames.toString());
    }

    private static String getPositionString(int position) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }
}
