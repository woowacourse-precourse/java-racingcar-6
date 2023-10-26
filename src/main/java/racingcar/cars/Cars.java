package racingcar.cars;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final int MAX_CAR_NAME_LENGTH = 5;
    private final List<String> cars;

    public Cars(String inputValue) {
        List<String> cars = parsedCarsName(inputValue);
        isValidCarNameLength(cars);
        this.cars = cars;
    }

    public List<String> getCars() {
        List<String> clonedCars = new ArrayList<>(cars);
        return Collections.unmodifiableList(clonedCars);
    }

    private List<String> parsedCarsName(String inputValue) {
        return Arrays.asList(inputValue.split(","));
    }

    private void isValidCarNameLength(List<String> cars) {
        for (String car : cars) {
            if (car.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
