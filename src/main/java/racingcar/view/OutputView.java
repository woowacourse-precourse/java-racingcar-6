package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    private static final String RACING_RESULT_MESSAGE = "실행 결과";
    private static final String RACING_WINNER_MESSAGE = "최종 우승자";
    private static final String RESULT_DELIMITER = " : ";
    private static final String PROGRESS_DELIMITER = "-";

    public static void printRacingResult() {
        System.out.println(System.lineSeparator() + RACING_RESULT_MESSAGE);
    }

    public static void printProgress(List<Car> cars) {
        for (Car car : cars) {
            int carPosition = car.getPosition();
            String progressString = generateProgressString(carPosition);

            System.out.println(car.getName() + RESULT_DELIMITER + progressString);
        }
    }

    private static String generateProgressString(int position) {
        return PROGRESS_DELIMITER.repeat(Math.max(0, position));
    }

    public static void printRacingWinner(String winners) {
        System.out.println(RACING_WINNER_MESSAGE + RESULT_DELIMITER + winners);
    }
}
