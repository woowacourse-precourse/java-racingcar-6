package racingcar.service;

import static racingcar.constants.MessageConstant.INPUT_SEPARATOR;
import static racingcar.constants.MessageConstant.WINNER_NAME_SEPARATOR;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;

public class CarGameService {

    public Cars convertToCars(final String input) {
        List<String> names = Arrays.stream(splitBySeparator(input))
                .toList();

        return Cars.of(names);
    }

    public void applyMovingForward(final Cars cars) {
        cars.applyMovingForward();
    }

    public String receiveWinnerNames(final Cars cars) {
        List<String> winnerNames = cars.receiveWinnerNames();
        return joinWinnerNames(winnerNames);
    }

    private String joinWinnerNames(final List<String> winnerNames) {
        return String.join(WINNER_NAME_SEPARATOR, winnerNames);
    }

    private String[] splitBySeparator(final String input) {
        return input.split(INPUT_SEPARATOR);
    }
}
