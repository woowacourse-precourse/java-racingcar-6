package racingcar.model;


import java.util.ArrayList;
import java.util.List;

public class Cars {
    public static List<Car> cars;
    public static String[] carNames;
    private static final String DELIMITER = ",";

    public static String[] makeCarList(String input) {
        return input.split(DELIMITER);
    }

    public static void putObject() {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

}
