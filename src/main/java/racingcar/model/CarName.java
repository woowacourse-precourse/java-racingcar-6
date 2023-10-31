package racingcar.model;

import java.util.List;

public class CarName {
    private List<String> carName;

    public CarName(List<String> carName) {
        this.carName = carName;
    }

    public CarName makeCarName(List<String> carName) {
        return new CarName(carName);
    }

    public String getNameOf(int index) {
        return carName.get(index);
    }

    public List<String> getCarName() {
        return carName;
    }

    public int getSize() {
        return carName.size();
    }
}
