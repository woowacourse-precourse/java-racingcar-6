package racingcar;

import static racingcar.Validation.validateLengthOfName;

public class Cars {
    private int distance;
    private String carName;

    public Cars(String carName) {
        validateLengthOfName(carName);
        this.carName = carName;
        this.distance = 0;
    }

    public int goOneStep() {
        return ++distance;
    }

    public String getName() {
        return this.carName;
    }

    public int askDistance() {
        return this.distance;
    }
}
