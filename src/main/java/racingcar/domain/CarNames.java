package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarNames {

    private List<String> carNames;

    public CarNames() {
        carNames = new ArrayList<>();
    }

    public void addCarName(String carName) {
        carNames.add(carName);
    }

    public int size() {
        return carNames.size();
    }

    public String get(int index) {
        return carNames.get(index);
    }

}
