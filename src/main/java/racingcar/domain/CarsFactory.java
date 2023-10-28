package racingcar.domain;

import static racingcar.constant.ExceptionMessage.BLANK_EXCEPTION;
import static racingcar.constant.ExceptionMessage.INVALID_NAME_EXCEPTION;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarsFactory {
    private final List<Car> cars = new ArrayList<>();

    public List<String> inputCarNames() {
        String inputNames = Console.readLine();
        List<String> carNames = Arrays.asList(inputNames.split(","));
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

    public List<Car> getCars() {
        return cars;
    }

}
