package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Race {
    private final static int CAN_MOVE = 4;
    private List<Car> carList;

    public Race(String inputCarNames) {
        carList = new ArrayList<>();
        setCarList(inputCarNames);
    }

    public void setCarList(String inputCarNames) {
        String[] carNameArray = inputCarNames.split(",");
        List<String> carNames = new ArrayList<>(Arrays.asList(carNameArray));
        for (String carName : carNames) {
            Car newCar = new Car(carName);
            carList.add(newCar);
        }
    }

    public List<String> getCarNames() {
        List<String> carNames = new ArrayList<>();
        for (Car car : carList) {
            carNames.add(car.getName());
        }
        return carNames;
    }

    public void moveCars() {
        for (Car car : carList) {
            int randomNumber = RandomGenerator.createNumber();
            if (randomNumber >= CAN_MOVE) {
                car.moveForward();
            }
        }
    }

    public List<Integer> getRoundResult() {
        List<Integer> result = new ArrayList<>();
        for (Car car : carList) {
            result.add(car.getDistance());
        }
        return result;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxDistance = getMaxDistance();
        for (Car car : carList) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxDistance() {
        List<Integer> result = getRoundResult();
        return Collections.max(result);
    }
}
