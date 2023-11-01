package racingcar.model;

import java.util.List;

public class RacingGame {

    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame() {
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public RacingGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public List<Car> move(List<Car> carList) {
        for (Car car : carList) {
            int number = randomNumberGenerator.generateRandomNumber();
            if (isOverFour(number))
                car.setDistance(car.getDistance()+1);
        }
        return carList;
    }

    private boolean isOverFour(int randomNumber) {
        return randomNumber >= 4;
    }

}