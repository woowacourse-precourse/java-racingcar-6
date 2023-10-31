package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import utils.GenerateRandomNumber;
import utils.Utils;

public class Cars {
    final static String DUPLICATION_NAME = "자동차의 이름은 중복되지 않은 고유한 값이어야 합니다.";
    private List<Car> cars;
    Utils utils = new Utils();

    public Cars(String input) {
        duplicateCarName(input);
        cars = convertStringArrayToCars(input);
    }

    public List<Car> convertStringArrayToCars(String input) {
        return Arrays.stream(utils.splitByDelimiter(input))
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

    public int getMaxPosition() {
        return cars.stream().map(car -> car.getNowPlace().length())
                .max(Integer::compareTo)
                .orElse(0);
    }

    public List<Car> getWinner() {
        return cars.stream().filter(car ->
                        car.getNowPlace().length() == getMaxPosition())
                .collect(Collectors.toList());
    }

    public void duplicateCarName(String input) {

        boolean duplicationName = Arrays.stream(input.split(","))
                .distinct().count() != input.split(",").length;

        if (duplicationName) {
            throw new IllegalArgumentException(DUPLICATION_NAME);
        }
    }
}
