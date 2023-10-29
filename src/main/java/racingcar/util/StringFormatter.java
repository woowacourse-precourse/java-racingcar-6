package racingcar.util;

import racingcar.domain.car.Car;
import racingcar.domain.CarGarage;
import racingcar.domain.Winner;

import java.util.List;

public class StringFormatter {

    private static final String CAR_NAME_POSITION_FORMAT = "%s : %s";
    private static final String POSITION_DELIMITER = "-";
    private static final String NEXT_LINE = "\n";

    private static final String WINNER_LINE = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";

    public String makeRaceResult(CarGarage garage) {
        StringBuilder sb = new StringBuilder();
        for (Car car : garage.cars()) {
            String formattedLine = applyFormat(car);
            sb.append(formattedLine).append(NEXT_LINE);
        }
        return sb.toString();
    }

    private String applyFormat(Car car) {
        return String.format(CAR_NAME_POSITION_FORMAT,
                car.getName(),
                POSITION_DELIMITER.repeat(car.getPosition())
        );
    }

    public String makeWinnerResult(Winner winner) {
        StringBuilder sb = new StringBuilder();
        sb.append(WINNER_LINE);
        List<String> names = getWinnerName(winner);
        sb.append(String.join(WINNER_DELIMITER, names));
        return sb.toString();
    }

    private static List<String> getWinnerName(Winner winner) {
        return winner.getValue().stream()
                .map(Car::getName)
                .toList();
    }
}
