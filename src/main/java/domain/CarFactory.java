package domain;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CarFactory {
    public static List<Car> generateCars(String userInput) {
        return Pattern.compile(",")
                .splitAsStream(userInput)
                .map(String::trim)
                .map(CarFactory::generateCar)
                .collect(Collectors.toList());
    }

    private static Car generateCar(String carName) {
        return new Car(new Name(carName));
    }
}
