package racingcar.car;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CarFactory {
    private CarFactory() {}
    private static final Pattern specialCharacterPattern = Pattern.compile("[ !@#$%^&*(),.?\":{}|<>]");
    private static final String CAR_SEPARATOR = ",";

    public static List<Car> createCar(String name) {
        List<String> names = splitCarName(name);
        for (String carName:names) {
            validateName(carName);
        }

        List<Car> cars = new ArrayList<>();
        for (String carName:names) {
            cars.add(Car.createCar(carName));
        }

        return cars;
    }

    private static List<String> splitCarName(String name) {
        return List.of(name.split(CAR_SEPARATOR));
    }

    private static void validateName(String name) {
        if (specialCharacterPattern.matcher(name).find()) {
            throw new IllegalArgumentException();
        }
    }
}
