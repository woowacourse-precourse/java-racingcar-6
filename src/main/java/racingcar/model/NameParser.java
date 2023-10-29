package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameParser {
    public List<String> parseCarName(String inputNames) {
        return Arrays.asList(inputNames.split(","));
    }

    public void carNameLengthUnderFive(List<String> carNameList) {
        for (String carName:carNameList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름이 5글자를 넘어갈 수 없습니다.");
            }
        }
    }

    public List<Car> setCar(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            Car newCar = new Car(carName, 0);
            carList.add(newCar);
        }
        return carList;
    }
}
