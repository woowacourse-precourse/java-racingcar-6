package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private static final String RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String CAR_POSITION = "-";

    public static void executionResult() {
        System.out.println(RESULT);
    }

    public static void resultPerAttempt(final List<Car> cars) {
        for (Car car : cars) {
            System.out.println(makeCarResult(car));
        }
    }

    public static void winner(final List<String> winners) {
        System.out.print(FINAL_WINNER + " : " + String.join(", ", winners));
    }

    private static String makeCarResult(final Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName() + " : ");

        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(CAR_POSITION);
        }

        return sb.toString();
    }
}
