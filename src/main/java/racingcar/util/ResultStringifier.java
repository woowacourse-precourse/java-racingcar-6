package racingcar.util;

import racingcar.domain.Car;

import java.util.List;

public class ResultStringifier {
    public static String generateProgressString(List<Car> cars) {
        StringBuilder progressBuilder = new StringBuilder();

        for (Car car : cars) {
            int carPosition = car.getPosition();
            String progressString = formatProgressString(carPosition);

            progressBuilder.append(String.format(Constants.PROGRESS_MESSAGE, car.getName(), progressString));
        }

        return progressBuilder.toString();
    }

    public static String generateWinnersString(List<String> winners) {
        return String.join(Constants.CAR_NAME_DELIMITER, winners);
    }

    private static String formatProgressString(int position) {
        return Constants.PROGRESS_DELIMITER.repeat(Math.max(0, position));
    }
}
