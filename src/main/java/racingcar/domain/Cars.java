package racingcar.domain;

import static racingcar.constant.ExceptionMessage.BLANK_EXCEPTION;
import static racingcar.constant.ExceptionMessage.DUPLICATE_EXCEPTION;
import static racingcar.constant.ExceptionMessage.INVALID_NAME_EXCEPTION;
import static racingcar.constant.ExceptionMessage.LENGTH_EXCEPTION;
import static racingcar.constant.GameMessage.DELIMITER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import racingcar.view.InputView;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public void createCars() {
        List<String> carNames = inputCarNames();
        carNames.forEach(name -> cars.add(new Car(name)));
    }

    public List<String> inputCarNames() {
        String inputNames = InputView.printRequestName();
        List<String> carNames = Arrays.asList(inputNames.split(DELIMITER, -1));
        validateCarNames(carNames);

        return carNames;
    }

    public void validateCarNames(List<String> carNames) {
        checkCarNameValidity(carNames);
        checkCarNameForBlank(carNames);
        checkCarNamesLength(carNames);
        checkCarNamesDuplicate(carNames);
    }

    /**
     * 이름으로 빈 문자열이 들어왔을 경우 예외 발생
     */
    public void checkCarNameValidity(List<String> carNames) {
        if (carNames.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException(INVALID_NAME_EXCEPTION);
        }
    }

    public void checkCarNameForBlank(List<String> carNames) {
        if (carNames.stream().anyMatch(name -> name.contains(" "))) {
            throw new IllegalArgumentException(BLANK_EXCEPTION);
        }
    }

    public void checkCarNamesLength(List<String> carNames) {
        if (carNames.stream().anyMatch(name -> name.length() == 0 || name.length() > 5)) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION);
        }
    }

    public void checkCarNamesDuplicate(List<String> carNames) {
        HashSet<String> uniqueNames = new HashSet<>();

        if (carNames.stream().anyMatch(name -> !uniqueNames.add(name))) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}
