package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<Car> carList;

    public CarList(String carsName) throws IllegalArgumentException {
        String[] names = splitNamesByComma(carsName);
        if (isBlankSpace(carsName) || !isValidNameLength(names)) {
            throw new IllegalArgumentException();
        }
        this.carList = new ArrayList<>();

    }

    private String[] splitNamesByComma(String name) {
        return name.split(",");
    }

    private boolean isValidNameLength(String[] names) {
        for (String name : names) {
            if (name.length() == 0 || name.length() >= 6) {
                return false;
            }
        }
        return true;
    }

    private boolean isBlankSpace(String names) {
        if (names.contains(" ")) {
            return false;
        }
        return true;
    }

}