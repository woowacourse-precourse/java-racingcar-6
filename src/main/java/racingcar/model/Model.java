package racingcar.model;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static racingcar.Constant.InputMenu.BLANK;
import static racingcar.Constant.InputMenu.COMMA;

public class Model {
    private Map<String, String> carList;

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Map<String, String> getCarList() {
        return carList;
    }

    public Map<String, String> createCarList(String carsInput) {
        this.carList = Arrays.stream(carsInput.split(COMMA)).collect(Collectors.toMap(car -> car, car -> BLANK));
        return carList;
    }
}
