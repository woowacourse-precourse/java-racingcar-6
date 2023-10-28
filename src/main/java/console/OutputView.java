package console;

import car.Car;
import car.Cars;

import java.util.List;

public class OutputView {
    private static final String ROUND_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자: ";
    private static final String PROGRESS_PREFIX = " : ";
    private static final String SPLIT_DELIMITER = ", ";
    private static final String LOCATION_COUNTER = "-";

    public void printRoundResult(Cars cars) {
        System.out.println(ROUND_RESULT);
        for (Car car : cars.getCarList()) {
            printCarProgress(car);
        }
        System.out.println();
    }

    private void printCarProgress(Car car) {
        StringBuilder progress = new StringBuilder(car.getName() + PROGRESS_PREFIX);
        for (int i = 0; i < car.getLocation(); i++) {
            progress.append(LOCATION_COUNTER);
        }
        System.out.println(progress);
    }

    public void printWinners(List<Car> winners) {
        System.out.print(FINAL_WINNER);
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            printDelimiterIfNotLast(winners, i);
        }
    }

    private void printDelimiterIfNotLast(List<Car> winners, int i) {
        if (i < winners.size() - 1) {
            System.out.print(SPLIT_DELIMITER);
        }
    }
}
