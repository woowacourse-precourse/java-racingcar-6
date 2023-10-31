package racingcar.model;

import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    List<Car> carList = new ArrayList<>();
    List<String> winners = new ArrayList<>();

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
        int max = 0;
        int maxDistance = getMaxDistance(max);
        addCarNameAtWinnersList(maxDistance);
        return winners;
    }

    private void addCarNameAtWinnersList(int maxDistance) {
        for (Car car : carList) {
            if (car.isSameDistance(car, maxDistance)) {
                winners.add(car.getName());
            }
        }
    }

    private int getMaxDistance(int max) {
        for (Car car : carList) {
            max = car.getMaxDistance(car, max);
        }
        return max;
    }
}
