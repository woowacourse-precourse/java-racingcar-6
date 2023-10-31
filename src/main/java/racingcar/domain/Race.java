package racingcar.domain;

import racingcar.utils.RandomNumberGenerater;

import java.util.List;

public class Race {
    int count;
    int times;
    Cars cars;

    private final RandomNumberGenerater randomNumberGenerater = new RandomNumberGenerater();

    public Race(Cars cars, int times) {
        this.cars = cars;
        this.times = times;
        this.count = 0;
    }

    public Race() {
    }

    public boolean run() {
        if (isFinished()) return false;
        increaseCount();
        play();
        return true;
    }

    public void play(){
        for (Car car : cars.getCars()) {
            int randomNumber = randomNumberGenerater.generateNumber();
            if (randomNumber >= 4) {
                car.increaseProcess();
            }
        }
    }

    public boolean isFinished(){
        if(count == times) return true;
        return false;
    }

    public void increaseCount(){
        count++;
    }

    public List<String> findWinner() {
        int maxProcess = cars.calculrateMaxProcess();
        return cars.getCars()
                .stream()
                .filter(car -> car.isWinner(maxProcess))
                .map(Car::getCarName)
                .toList();
    }
}
