package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNameList {
    private final List<String> carNameList;

    public CarNameList(String[] carNames) {
        carNameList = new ArrayList<>();
        carNameList.addAll(Arrays.asList(carNames));
    }

    public List<String> getCarNameList() {
        return this.carNameList;
    }
}