package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import utils.GenerateRandomNumber;
import utils.Utils;

public class Cars {
    private List<Car> cars;
    Utils utils = new Utils();

    public Cars(String input) {
        utils.duplicateCarName(input);
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

}
