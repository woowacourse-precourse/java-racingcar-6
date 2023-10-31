package racingcar.view;

import racingcar.model.Car;

public class ResultView {
    private static final String CAR_POSITION_MARKER = "-";

    public static void printCarPosition(Car car) {
        StringBuilder result = new StringBuilder(car.getName()).append(" : ");
        appendCarPosition(result, car.getPosition());
        System.out.println(result);
    }

    private static void appendCarPosition(StringBuilder result, int position) {
        for (int i = 0; i < position; i++) {
            result.append(CAR_POSITION_MARKER);
        }
    }

    public static void printNewLine() {
        System.out.println();
    }
}
