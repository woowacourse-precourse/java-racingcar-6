package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class ResultView {
    private static final String CAR_POSITION_MARKER = "-";
    private static final String COMMA = ", ";

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

    public static void printWinners(List<String> winners) {
        String winnerNames = String.join(",",winners);
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
