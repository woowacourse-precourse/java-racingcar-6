package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

import java.util.List;

public class RacingMachine {
    private List<Car> cars;
    private int playCount;

    public RacingMachine(List<Car> cars, int playCount) {
        this.cars = cars;
        this.playCount = playCount;
    }

    public boolean canPlay() {
        return playCount > 0;
    }

    public void play() {
        for (Car car : cars) {
            car.move(RandomNumberGenerator.generate());
        }
        playCount--;
    }

    public List<Car> getCars() {
        return cars;
    }
}
