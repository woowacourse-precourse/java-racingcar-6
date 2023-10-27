package racingcar.cars;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final int MAX_CAR_NAME_LENGTH = 5;
    private List<Car> cars = new ArrayList<>();

    public Cars(String inputValue) {
        List<String> carNames = parsedCarsName(inputValue);
        isValidCarNameLength(carNames);
        for(String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public List<String> getCarNames() {
        List<String> carsName = new ArrayList<>();
        for(Car car : cars) {
            carsName.add(car.getName());
        }
        return carsName;
    }

    public void printMoveRecord(String carName, int moveRecord) {
        System.out.print(carName + " : ");
        for (int repeatCount = 0; repeatCount < moveRecord; repeatCount++) {
            System.out.print("-");
        }
    }

    private List<String> parsedCarsName(String inputValue) {
        return Arrays.asList(inputValue.split(","));
    }

    private void isValidCarNameLength(List<String> cars) {
        for (String car : cars) {
            if (car.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }
}
