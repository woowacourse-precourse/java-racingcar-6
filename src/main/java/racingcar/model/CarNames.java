package racingcar.model;

import java.util.List;

public class CarNames {

    private final List<String> carNames;


    public CarNames(List<String> carNames) {
        validateNameLength(carNames);
        this.carNames = carNames;
    }

    public List<String> getNames() {
        return this.carNames;
    }

    public void validateNameLength(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            if (carNames.get(i).length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }


}
