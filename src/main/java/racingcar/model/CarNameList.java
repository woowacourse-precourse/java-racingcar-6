package racingcar.model;

import java.util.List;

public class CarNameList {
    private final List<String> carNameList;

    private CarNameList(List<String> carNameList) {
        this.carNameList = carNameList;
    }

    public static CarNameList createCar (List<String> carNameList) {
        return new CarNameList(carNameList);
    }

    public Integer countCar() {
        return carNameList.size();
    }

    public String toString(Integer index) {
        return carNameList.get(index);
    }
}
