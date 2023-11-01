package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import racingcar.domain.exception.BadCarNameException;
import racingcar.domain.exception.DuplicateCarNameException;

public class Cars {
    private static final String CAR_NAME_DELIMITER = ",";
    private final List<Car> cars = new ArrayList<>();

    private Cars(List<String> carNames) {
        for (String carName : carNames) {
            this.cars.add(Car.create(carName));
        }
    }

    public static Cars create(String carNameString) {
        check0Length(carNameString);
        String[] carNamesWithBlank = splitCarNames(carNameString);
        List<String> trimmedCarNames = trimCarNames(carNamesWithBlank);
        checkDuplicate(trimmedCarNames);
        return new Cars(trimmedCarNames);
    }

    private static void check0Length(String carNames) {
        if (carNames.contains(CAR_NAME_DELIMITER.repeat(2))
                || carNames.startsWith(CAR_NAME_DELIMITER)
                || carNames.endsWith(CAR_NAME_DELIMITER)) {
            throw new BadCarNameException("자동차 이름 길이 제한을 벗어났습니다.");
        }
    }

    private static String[] splitCarNames(String carNames) {
        String[] splittedCarNames = carNames.split(CAR_NAME_DELIMITER);
        if (splittedCarNames.length == 0) {
            throw new BadCarNameException("자동차 이름 길이 제한을 벗어났습니다.");
        }
        return splittedCarNames;
    }

    private static List<String> trimCarNames(String[] splittedCarNames) {
        return Arrays.stream(splittedCarNames).map(String::trim).toList();
    }

    private static void checkDuplicate(List<String> carNames) {
        HashSet<String> carNameSet = new HashSet<>();
        for (String carName : carNames) {
            if (carNameSet.contains(carName)) {
                throw new DuplicateCarNameException("중복된 이름이 존재합니다.");
            }
            carNameSet.add(carName);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
