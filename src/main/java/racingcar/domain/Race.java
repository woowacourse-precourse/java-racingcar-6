package racingcar.domain;

import racingcar.controller.RandomNumberGenerater;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    int count;

    int times;
    Cars cars;

    private final RandomNumberGenerater randomNumberGenerater = new RandomNumberGenerater();
    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getCount() {
        return count;
    }
    public void increaseCount(){
        count++;
    }

    public Cars getCars() {
        return cars;
    }

    public boolean run(List<Car> carList) {
        if (getCount() == getTimes()) {
            return false;
        }

        increaseCount();

        for (Car car : carList) {
            int randomNumber = randomNumberGenerater.generateNumber();
            if (randomNumber >= 4) {
                car.increaseProcess();
            }
        }

        return true;
    }

    public List<Car> getWinner(List<Car> carList) {
        int max = carList.stream()
                .mapToInt(Car::getProcess)
                .max()
                .getAsInt();
        return carList.stream()
                .filter(car -> car.getProcess() >= max)
                .toList();
    }

    public String getWinnersString(List<Car> winnerList) {
        return winnerList.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }

}
