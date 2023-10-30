package racingcar;

import java.util.List;

public class OutputView {
    public static final String COLON = " : ";

    public static void printResult(Car car, List<String> distance) {
        String convertedDistance = Converter.convertDistance(distance);
        System.out.println(car.getName() + COLON + convertedDistance);
    }

    public static void printWinners(List<Car> winners) {
        String result = String.join(",", Converter.convertWinners(winners));
        System.out.println(result);
    }
}
