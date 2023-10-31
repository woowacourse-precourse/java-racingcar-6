package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarNames {
    private List<String> carNames;

    public CarNames(final List<String> carNames) {
        this.carNames = new ArrayList<>(carNames);
    }

    public List<String> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }

    public int size() {
        return carNames.size();
    }

    public String getElementAtIndex(int index) {
        if (index < 0 || index >= carNames.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        return carNames.get(index);
    }
}
