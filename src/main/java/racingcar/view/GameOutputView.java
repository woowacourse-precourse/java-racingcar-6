package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class GameOutputView {

    private static final String DASH_LINE = "-";

    public static void displayCurrentCarStatuses(List<Car> cars) {
        cars.forEach(
                car -> {
                    String carName = car.getName();
                    String dashLines = getDashLines(car.getPosition());
                    System.out.println(carName + " : " + dashLines);
                }
        );
        System.out.println();
    }

    public static void printWinnerNames(List<String> winnerNames) {
        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }

    private static String getDashLines(int numOfDashLines) {
        return DASH_LINE.repeat(numOfDashLines);
    }
}
