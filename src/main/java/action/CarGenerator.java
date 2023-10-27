package action;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CarGenerator {

    private static final int LENGTH = 5;
    private final String[] carNameArray;

    public CarGenerator(String carString) {
        carNameArray = carSplit(carString);
    }

    public String[] carSplit(String carString) {
        return carString.split(",");
    }

    public List<Car> makeCars() {
        List<Car> carList = new LinkedList<>();

        for (String car : carNameArray) {
            checkNameLength(car);
            carList.add(new Car(car));
        }

        return carList;
    }

    public void checkNameLength(String carName) throws IllegalArgumentException {
        if (carName.length() > LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
