package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarFactory;

public class RacingCarGameService implements CarGameService {

    private final CarFactory factory;

    public RacingCarGameService(CarFactory factory) {
        this.factory = factory;
    }

    @Override
    public void makeAndStoreCar(String[] carNames) {
        for (String carName : carNames) {
            factory.addCar(carName);
        }
    }

    @Override
    public void updateCar(List<Integer> randomNumbers) {
        factory.updateCarDistance(randomNumbers);
    }

    @Override
    public List<Car> getDuplicatedCars() {
        return factory.getNameAndDistance();
    }
}
