package racingcar.game.car;

import java.util.ArrayList;
import java.util.List;
import racingcar.game.car.engin.CarEngineV1;
import racingcar.game.inputgenerateManager.InputGenerateManager;

public class CarFactory {
    private final InputGenerateManager inputGenerateManager;

    public CarFactory(InputGenerateManager inputGenerateManager) {
        this.inputGenerateManager = inputGenerateManager;
    }

    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName, new CarEngineV1(inputGenerateManager));
            cars.add(car);
        }
        return cars;
    }
}
