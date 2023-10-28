package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;

public class CarGameService {

    private static final String NAME_SEPARATOR = ",";

    public Cars convertToCars(String input) {
        List<String> carList = convertToList(input);
        return Cars.of(new ArrayList<>(carList));
    }

    public void applyMovingForward(Cars cars) {
        cars.applyMovingForward();
    }

    public String receiveWinnerNames(Cars cars) {
        return cars.selectWinnerNames();
    }

    private List<String> convertToList(String input) {
        return Arrays.asList(splitBySeparator(input));
    }

    private String[] splitBySeparator(String input) {
        return input.split(NAME_SEPARATOR);
    }
}
