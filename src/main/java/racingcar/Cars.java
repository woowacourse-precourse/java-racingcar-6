package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCarList(String userInput) {
        List<Car> carList = putCarIntoList(extractNamesList(userInput));

        return new Cars(carList);
    }

    private static List<Car> putCarIntoList(List<String> names) {
        List<Car> cars = names.stream()
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());

        return Collections.unmodifiableList(cars);
    }

    private static List<String> extractNamesList(String userInput) {
        String[] names = userInput.split(",");

        return List.of(names);
    }
}
