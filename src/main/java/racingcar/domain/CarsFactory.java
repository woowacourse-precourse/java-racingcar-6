package racingcar.domain;

import static racingcar.constant.ExceptionMessage.BLANK_EXCEPTION;
import static racingcar.constant.ExceptionMessage.DUPLICATE_EXCEPTION;
import static racingcar.constant.ExceptionMessage.INVALID_NAME_EXCEPTION;
import static racingcar.constant.ExceptionMessage.LENGTH_EXCEPTION;
import static racingcar.constant.GameMessage.DELIMITER;
import static racingcar.constant.GameNumber.NAME_EMPTY_LENGTH;
import static racingcar.constant.GameNumber.NAME_MAXIMUM_LENGTH;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import racingcar.view.InputView;

public class CarsFactory {
    private final List<Car> cars = new ArrayList<>();

    public void startCreateCars() {
        InputView.printRequestName();
        createCars();
    }

    public void createCars() {
        List<String> carNames = inputCarNames();
        carNames.forEach(name -> cars.add(new Car(name)));
    }

    public List<String> inputCarNames() {
        String inputNames = Console.readLine();
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
        for (String name : carNames) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException(INVALID_NAME_EXCEPTION);
            }
        }
    }

    public void checkCarNameForBlank(List<String> carNames) {
        for (String name : carNames) {
            if (name.contains(" ")) {
                throw new IllegalArgumentException(BLANK_EXCEPTION);
            }
        }
    }

    public void checkCarNamesLength(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() == NAME_EMPTY_LENGTH || name.length() > NAME_MAXIMUM_LENGTH) {
                throw new IllegalArgumentException(LENGTH_EXCEPTION);
            }
        }
    }

    public void checkCarNamesDuplicate(List<String> carNames) {
        HashSet<String> uniqueNames = new HashSet<>();

        for (String name : carNames) {
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException(DUPLICATE_EXCEPTION);
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}
