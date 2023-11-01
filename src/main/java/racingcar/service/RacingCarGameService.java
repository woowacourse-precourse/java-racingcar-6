package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarStorage;

public class RacingCarGameService implements CarGameService {
    private final CarStorage storage;

    public RacingCarGameService(CarStorage storage) {
        this.storage = storage;
    }

    @Override
    public void updateCar(List<Integer> randomNumbers) {
        storage.updateCarDistance(randomNumbers);
    }

    @Override
    public List<Car> getDuplicatedCars() {
        return storage.getNameAndDistance();
    }
}
