package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;

public class CarNameParser {

    private final static int CAR_NAME_LIMIT = 5;

    public List<String> parseCarName(String inputNames) {
        return Arrays.asList(inputNames.split(","));
    }

    public void carNameLengthUnderFive(List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > CAR_NAME_LIMIT) {
                throw new IllegalArgumentException("이름이 5글자를 넘어갈 수 없습니다.");
            }
        }
    }

    private void addCarToList(List<Car> carList, String carName) {
        Car newCar = new Car(carName);
        carList.add(newCar);
    }

    public List<Car>stringToCarName(List<String>carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            addCarToList(carList, carName);
        }
        return carList;
    }
}
