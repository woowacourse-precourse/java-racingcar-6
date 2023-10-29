package racingcar.view;

import racingcar.domain.Car;
import racingcar.util.Constants;

import java.util.List;

public class OutputView {
    public static void printRacingResult() {
        System.out.println(Constants.RACING_RESULT_MESSAGE);
    }

    public static void printProgress(List<Car> cars) {
        StringBuilder progressBuilder = new StringBuilder();

        for (Car car : cars) {
            int carPosition = car.getPosition();
            String progressString = generateProgressString(carPosition);

            progressBuilder.append(String.format(Constants.PROGRESS_MESSAGE, car.getName(), progressString));
        }

        System.out.println(progressBuilder);
    }

    private static String generateProgressString(int position) {
        return Constants.PROGRESS_DELIMITER.repeat(Math.max(0, position));
    }

    public static void printRacingWinner(List<Car> winners) {
        String winnerNames = getWinnerNamesToString(winners);

        System.out.printf(Constants.RACING_WINNER_MESSAGE, winnerNames);
    }

    private static String getWinnerNamesToString(List<Car> winners) {
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .toList();

        return String.join(Constants.CAR_NAME_DELIMITER, winnerNames);
    }
}
