package racingcar.model;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Race {
    private List<Car> carList;

    public Race(String inputCarNames) {
        carList = new ArrayList<>();
        setCarList(inputCarNames);
    }

    public void setCarList(String inputCarNames) {
        String[] carNameArray = inputCarNames.split(",");
        List<String> carNames = new ArrayList<>(Arrays.asList(carNameArray));
        for (String carName : carNames) {
            // carName에 대한 예외 검사
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
            if (randomNumber > 4) {
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

}
