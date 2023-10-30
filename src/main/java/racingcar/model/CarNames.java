package racingcar.model;

import java.util.List;

public class CarNames {

    private final List<String> carNames;


    public CarNames(List<String> carNames) {
        this.carNames = carNames;
    }

    public List<String> getNames() {
        return this.carNames;
    }

}
