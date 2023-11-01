package racingcar.model;

import static racingcar.view.OutputView.LOCATION_AND_NAME_DELIMITER;

public class Car {
    public static final String LOCATION = "-";
    private final CarName name;
    private int location = 0;

    public Car(String name) {
        this.name = new CarName(name);
    }

    @Override
    public String toString() {
        String result = name.name() + LOCATION_AND_NAME_DELIMITER;
        for (int i = 0; i < location; i++) {
            result += LOCATION;
        }
        return result;
    }

    public String getName() {
        return this.name.name();
    }

    public void goOrStop(int i) {
        if (i > 3) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }
}
