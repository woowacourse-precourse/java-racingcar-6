package racingcar.service;

import static racingcar.constants.MessageConstant.INPUT_SEPARATOR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;

public class CarGameService {

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
        return input.split(INPUT_SEPARATOR);
    }
}
