package racingcar.view;

import racingcar.model.Car;

public class ResultView {
    private static final String CAR_POSITION_MARKER = "-";

    public static void printCarPosition(Car car) {
        StringBuilder result = new StringBuilder(car.getName()).append(" : ");
        appendCarPosition(result, car.getPosition());
        System.out.println(result);
    }
}
