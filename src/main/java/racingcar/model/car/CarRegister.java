package racingcar.model.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRegister {
    private final List<String> carNames;

    public CarRegister() {
        this.carNames = new ArrayList<>();
    }

    public void registerCar(String carName) {
        carNames.add(carName);
    }

    public CarList prepareCarList(){
        return new CarList(carNames.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toUnmodifiableList()));
    }
}
