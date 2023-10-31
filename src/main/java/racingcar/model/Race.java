package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> cars;
    private int totalRounds;
    private int currentRound;

    public Race(List<String> carNames, int totalRounds) {
        this.cars = createCars(carNames);
        this.totalRounds = totalRounds;
        this.currentRound = 0;
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void runRound() {
        for (Car car : cars) {
            int randomNumber = RandomNumberService.generate();
            car.tryMove(randomNumber);
        }
        currentRound++;
    }

    public boolean isRaceFinished() {
        return currentRound >= totalRounds;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> findWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}

