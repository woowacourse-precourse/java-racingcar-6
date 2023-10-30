package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingCars;

import java.util.HashMap;
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

    public HashMap<String,Integer> race() {
        moveOrStop();
        HashMap<String, Integer> raceResult = new HashMap<>();
        for (Car car : cars.getRacingCars()) {
            raceResult.put(car.getName(), car.getDistance());
        }
        return raceResult;
    }

    private void moveOrStop() {
        List<Car> RacingCars = cars.getRacingCars();
        for (Car car : RacingCars) {
            int num = randomNumberGenerator.getRandomNumber();
            car.moveOrStop(num);
        }
        tryCount -= 1;
    }

    public Boolean isContinue() {
        if (tryCount == 0) {
            return false;
        }return true;
    }
}
