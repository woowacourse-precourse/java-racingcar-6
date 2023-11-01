package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarNames;
import racingcar.domain.Cars;

public class RacingcarGameServiceImpl implements RacingcarGameService {

    @Override
    public Cars generateCarsToRace(String inputMessage) {
        CarNames carNames = generateCarName(inputMessage);

        Cars cars = new Cars();
        for (int i = 0; i < carNames.size(); i++) {
            cars.addCar(Car.of(carNames.get(i)));
        }

        return cars;
    }

    private CarNames generateCarName(String inputMessage) {
        CarNames carNames = new CarNames();

        for (String carName : inputMessage.split(",")) {
            carNames.addCarName(carName);
        }

        return carNames;
    }

}
