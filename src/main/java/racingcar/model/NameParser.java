package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class NameParser {
    public List<String> parseCarName(String inputNames) {
        return Arrays.asList(inputNames.split(","));
    }

    public void carNameLengthUnderFive(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름이 5글자를 넘어갈 수 없습니다.");
        }
    }

    public void setCar(List<String> carNameList) {
        for (String carName : carNameList) {
            carNameLengthUnderFive(carName);
            Car car = new Car(carName, 0);
        }
    }
}
