package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 :";

    public static void executionMessage() {
        System.out.println();
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public static void executionResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + racingRecord(car.getPosition()));
        }
    }

    private static String racingRecord(int count) {
        String record = "";
        for (int i = 0; i < count; i++) {
            record += "-";
        }
        return record;
    }

    public static void Winner(String[] winners) {
        System.out.print(WINNER_MESSAGE);
        System.out.print(concatResult(winners));
    }

    private static String concatResult(String[] words) {
        String result = "";
        for (String word : words) {
            result += " " + word + ",";
        }
        return result.substring(0, result.length() - 1);
    }
}
