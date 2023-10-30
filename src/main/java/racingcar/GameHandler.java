package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameHandler {
    private final List<Car> cars;

    public GameHandler() {
        this.cars = new ArrayList<>();
    }

    public void handle() {
        List<String> carNames = Communicator.instructInputCars();
        saveCars(carNames);
        Communicator.instructInputGameTimes();
    }

    private void saveCars(List<String> carNames) {
        carNames.stream()
                .map(carName -> new Car(carName, 0))
                .forEach(cars::add);
    }
}
