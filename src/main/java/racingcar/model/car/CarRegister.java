package racingcar.model.car;

import java.util.ArrayList;
import java.util.List;

public class CarRegister {
    private final List<String> carNames;

    public CarRegister() {
        this.carNames = new ArrayList<>();
    }

    public void registerCar(String carName) {
        carNames.add(carName);
    }
}
