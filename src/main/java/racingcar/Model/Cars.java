package racingcar.Model;

import static racingcar.Validation.validateLengthOfName;

public class Cars {
    private int distance;
    private final String carName;

    public Cars(String carName) {
        validateLengthOfName(carName);
        this.carName = carName;
        this.distance = 0;
    }

    public void goOneStep() {
        ++distance;
    }

    public String getName() {
        return this.carName;
    }

    public int askDistance() {
        return this.distance;
    }

}