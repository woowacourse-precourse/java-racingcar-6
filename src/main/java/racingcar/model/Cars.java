package racingcar.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    public static List<Car> cars;
    public static List<String> carNames;
    private static final String DELIMITER = ",";

    public static List<String> makeCarList(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

    public static void putObject() {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

}
