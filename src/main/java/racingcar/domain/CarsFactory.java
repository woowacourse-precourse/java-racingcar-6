package racingcar.domain;

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

    public List<Car> getCars() {
        return cars;
    }

}
