package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.utils.RandomNumberCreator;

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
    public List<Car> updateCar() {
        factory.updateCarDistance(makeRandomNumbers());
        return factory.getNameAndDistance();
    }

    @Override
    public List<Integer> makeRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < factory.getNumOfCars(); i++) {
            randomNumbers.add(RandomNumberCreator.makeRandomNumber());
        }
        return randomNumbers;
    }
}
