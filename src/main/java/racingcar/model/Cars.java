package racingcar.model;

import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    List<Car> carList = new ArrayList<>();

    private void save(String carName) {
        carList.add(new Car(carName));
    }

    private void moveForward(Car car) {
        car.move();
    }

    public List<String> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }

    public void saveCarNameList(List<String> carNameList) {
        for (String carName : carNameList) {
            save(carName);
        }
    }

    public List<Car> game() {
        for (int i = 0; i < carList.size(); i++) {
            if (randomNumberGenerator.pickRandomNumber() >= 4) {
                moveForward(carList.get(i));
            }
        }
        return carList;
    }

    public List<String> getGameWinner() {
        List<String> winners = new ArrayList<>();
        int max = 0;
        for (Car car : carList) {
            if (car.getDistance() == max) {
                winners.add(car.getName());
            }
            if (car.getDistance() > max) {
                winners.clear();
                winners.add(car.getName());
                max = car.getDistance();
            }
        }
        return winners;
    }
}
