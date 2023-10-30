package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import static racingcar.validator.InputValidation.*;

public class RacingCarList {
    private List<RacingCar> car;
    private final static String SEPARATE_REGEX = ",";

    public RacingCarList(String inputs) {
        splitByComma(inputs);
    }

    private void splitByComma(String inputs) {
        car = new ArrayList<>();
        String[] names = inputs.split(SEPARATE_REGEX);
        for (String name : names) {
            validNameFormat(name);
            validNameLength(name);
            this.car.add(new RacingCar(name));
        }
    }

    public int size() {
        return this.car.size();
    }

    public RacingCar getCar(int index) {
        return this.car.get(index);
    }
}
