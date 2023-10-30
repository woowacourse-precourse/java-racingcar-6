package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    private static final String RESULT_NOTICE_MESSAGE = "실행 결과";
    private static final String WINNER_NOTICE_MESSAGE = "최종 우승자 : ";
    private static final String HYPHEN = "-";
    private static final String COLON = " : ";
    private static final String COMMA = ", ";

    public static void printResultMessage() {
        System.out.println(RESULT_NOTICE_MESSAGE);
    }

    public static void printResult(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            String name = car.getName();
            long distance = car.getDistance();
            StringBuilder hyphen = new StringBuilder();

            for (long j = 0; j < distance; j++) {
                hyphen.append(HYPHEN);
            }

            System.out.println(name + COLON + hyphen);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.print(WINNER_NOTICE_MESSAGE);
        System.out.println(String.join(COMMA, winners));
    }
}