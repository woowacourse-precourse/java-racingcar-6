package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.validation.UserInputValidation;

public class CarController {
    UserInputValidation userInputValidation = new UserInputValidation();

    public List<Car> makeCarObjectList(List<String> carNamesList) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNamesList) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public List<String> makeCarList(String carNames) {
        String[] inputArray = carNames.split(",");

        List<String> carNameList = new ArrayList<>();
        for (String carName : inputArray) {
            userInputValidation.checkCarNameValidation(carName);
            carNameList.add(carName);
        }
        return carNameList;
    }

    public boolean canMove(int generateNumber) {
        if (generateNumber < 4) {
            return false;
        }
        return true;
    }

    public void showCurrentPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + ":" + getPositionToString(car.getPosition()));
        }
        System.out.println();
    }

    public String getPositionToString(int position) {
        StringBuilder stringPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringPosition.append("-");
        }
        return stringPosition.toString();
    }

    public List<String> calculateWinner(List<Car> cars) {
        int maxPostion = calculateMaxPosition(cars);

        List<String> winnerList = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPostion) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    private static int calculateMaxPosition(List<Car> cars) {
        int maxPostion = 0;
        for (Car car : cars) {
            maxPostion = Math.max(maxPostion, car.getPosition());
        }
        return maxPostion;
    }

}
