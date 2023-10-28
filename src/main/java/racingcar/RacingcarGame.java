package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingCars;

import java.util.ArrayList;
import java.util.List;

public class RacingcarGame {

    private RacingCars cars;
    private int tryCount;

    private RandomNumberGenerator randomNumberGenerator;

    public RacingcarGame() {
        this.cars = new RacingCars();
        this.tryCount = 0;
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public void setCars(String[] carsName) {
        cars.setRacingCars(carsName);
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public void raceStart() {
        do {
            moveOrStop();
        }while(tryCount > 0);
    }

    private void moveOrStop() {
        List<Car> RacingCars = cars.getRacingCars();
        for (Car car : RacingCars) {
            int num = randomNumberGenerator.getRandomNumber();
            car.moveOrStop(num);
        }
        tryCount -= 1;
    }
}
