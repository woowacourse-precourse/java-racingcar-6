package racingcar;

import static racingcar.Validation.validateLengthOfName;

public class Cars {
    private int distance = 0;
    private String carName;

    public Cars(String carName) {
        validateLengthOfName(carName);
        this.carName = carName;
    }

    public int goForward() {
        return ++distance;
    }

    public String getName() {
        return this.carName;
    }

    public int askDistance() {
        return this.distance;
    }
}
