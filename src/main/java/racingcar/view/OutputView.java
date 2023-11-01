package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    private static final String DISTANCE_MARK = "-";

    public static void printPlayMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + getDistanceDisplay(car.getPosition()));
        }
        System.out.println();
    }

    private static String getDistanceDisplay(int count) {
        return DISTANCE_MARK.repeat(count);
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
