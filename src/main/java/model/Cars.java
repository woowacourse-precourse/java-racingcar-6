package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import utils.GenerateRandomNumber;
import utils.Utils;

public class Cars {
    final static String DUPLICATION_NAME = "자동차의 이름은 중복되지 않은 고유한 값이어야 합니다.";
    final static String DELIMITER = ",";
    private List<Car> cars;

    public Cars(String input) {
        duplicateCarName(input);
        cars = convertStringArrayToCars(input);
    }

    public List<Car> convertStringArrayToCars(String input) {
        return Arrays.stream(Utils.splitByDelimiter(input, DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void allTryMove() {
        cars.stream().forEach(car -> {
            car.tryMove(GenerateRandomNumber.pick());
        });
    }

    public Winners getWinners() {
        Winners winners = new Winners(cars);
        return winners;
    }

    public void duplicateCarName(String input) {

        boolean duplicationName = Arrays.stream(input.split(DELIMITER))
                .distinct().count() != input.split(DELIMITER).length;

        if (duplicationName) {
            throw new IllegalArgumentException(DUPLICATION_NAME);
        }
    }
}
