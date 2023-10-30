package racingcar;

import java.util.List;

public class OutputView {
    public static final String COLON = " : ";
    public static final String ENTER = "/n";

    public static void printResult(Car car, List<String> distance) {
        System.out.println(car.getName() + COLON + distance);
        System.out.println(ENTER);
    }

    public void printWinners() {

    }
}
