package racingcar.domain.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    private static final String RUN_RESULT_MESSAGE = "\n실행 결과";
    private static final String CAR_DISTANCE_SEPARATION = " : ";
    private static final String DISTANCE_SIGN = "-";
    public static final String WINNER_NAME_DELIMITER = ", ";
    public static final String WINNER_FORMAT_MESSAGE = "최종 우승자 : %s";

    public static void showStartRace() {
        System.out.println(RUN_RESULT_MESSAGE);
    }

    public static void showRaceProgress(List<Car> cars) {
        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            sb.append(car.getName()).append(CAR_DISTANCE_SEPARATION).append(DISTANCE_SIGN.repeat(car.getPosition())).append("\n");
        }

        System.out.println(sb);
    }

    public static void showWinner(List<String> cars) {
        String winnersName = String.join(WINNER_NAME_DELIMITER, cars);
        System.out.printf(WINNER_FORMAT_MESSAGE, winnersName);
    }
}
