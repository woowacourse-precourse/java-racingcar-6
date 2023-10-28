package racingcar.service;

import static racingcar.constants.MessageConstant.INPUT_SEPARATOR;
import static racingcar.constants.MessageConstant.WINNER_NAME_SEPARATOR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;

public class CarGameService {

    public Cars convertToCars(final String input) {
        List<String> carList = convertToList(input);
        return Cars.of(new ArrayList<>(carList));
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

    private List<String> convertToList(final String input) {
        return Arrays.asList(splitBySeparator(input));
    }

    private String[] splitBySeparator(final String input) {
        return input.split(INPUT_SEPARATOR);
    }
}
