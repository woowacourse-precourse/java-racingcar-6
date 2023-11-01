package racingcar.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.common.util.ErrorMessage;

public class Cars {

    private final List<Car> carList;

    public Cars(String carsName) {
        this.carList = stringToList(carsName);
    }

    private List<Car> stringToList(String carsName) {
        String[] result = carsName.split(",");
        Set<String> uniqueCarsName = new HashSet<>();

        return Arrays.stream(result)
                .filter(carName -> {
                    if (!carName.isEmpty()) {
                        uniqueCarName(carName, uniqueCarsName);
                        return true;
                    }
                    return false;
                })
                .map(Car::new)
                .toList();
    }

    private static void uniqueCarName(String carName, Set<String> uniqueCarsName) {
        if (!uniqueCarsName.add(carName)) {
            throw new IllegalArgumentException(ErrorMessage.VALIDATE_UNIQUE_CAR_NAME
                    .getMessage() + carName);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
