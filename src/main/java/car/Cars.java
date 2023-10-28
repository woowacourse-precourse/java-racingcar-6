package car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> carList;
    private static final int CAR_NAME_LIMIT = 5;
    private static final String NAME_LENGTH_INVALID = "이름은 5자 이하만 가능하다.";
    private static final String SPLIT_DELIMITER = ",";

    public Cars(String userInput) {
        this.carList = this.initByStringInput(userInput);
    }

    public List<Car> getCarList() { // 테스트에서만 사용하는 것이라면 없애도 되지 않을까?
        return new ArrayList<>(carList);
    }

    public List<String> getCarNames() {
        return carList.stream().map(Car::getName).toList();
    }

    public List<String> getWinnersNames() {
        int maxLocation = carList.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
        return carList.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .toList();
    }

    public void move() {
        this.carList.forEach(Car::move);
    }

    private List<Car> initByStringInput(String userInput) {
        String[] carNames = userInput.split(SPLIT_DELIMITER);
        return Arrays.stream(carNames)
                .map(String::trim) // 양옆 공백을 제거한다.
                .map(carName -> {
                    validateLength(carName);
                    return new Car(carName);
                })
                .toList();
    }

    private void validateLength(String carName) {
        if (carName.length() > CAR_NAME_LIMIT) {
            throw new IllegalArgumentException(NAME_LENGTH_INVALID);
        }
    }
}
