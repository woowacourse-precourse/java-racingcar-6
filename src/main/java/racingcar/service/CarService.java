package racingcar.service;

import racingcar.CarPosition;
import racingcar.domain.Car;
import racingcar.utils.BuilderUtils;
import racingcar.utils.RandomUtils;
import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    private List<String> carsName = new ArrayList<>();
    private Car[] car;
    private int carCount;
    private BuilderUtils builderUtils;

    public int initInputCarName(String carName) {

        CarNameValidator carNameValidator = new CarNameValidator();

        carsName = carNameValidator.validateInputCarName(carName) ;

        carCount = carsName.size();

        return carCount;
    }

    public void initCar() {
        car = new Car[carCount];

        for (int i = 0; i < carCount; i++) {
            car[i] = new Car(carsName.get(i), 0);
        }
    }

    public void initBuilder() {
        builderUtils = new BuilderUtils(carsName);
    }

    public void updateCarPosition() {
        RandomUtils randomUtils = new RandomUtils();

        for (int carIndex = 0; carIndex < carsName.size(); carIndex++) {

            CarPosition position = randomUtils.determinePositionByRandomNumber();

            if (position.increase(car[carIndex])) {
                builderUtils.appendToCarPosition(carIndex);
            }
        }
    }

    public String[] getGameStatus() {
        return builderUtils.getCarPositions();
    }

    public List<String> getWinner(List<String> winner) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < carCount; i++) {
            if (car[i].getPosition() > max) {
                winner.clear();
                winner.add(car[i].getCarName());
                max = car[i].getPosition();
            } else if (car[i].getPosition() == max) {
                winner.add(car[i].getCarName());
            }
        }
        return winner;
    }
}
