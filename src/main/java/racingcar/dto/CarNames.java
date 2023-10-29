package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

/*
 *   자동차 이름 정보를 담당
 * */


public class CarNames {
    private List<String> names = new ArrayList<>();

    public CarNames() {

    }

    public void addName(String name) {
        names.add(name);
    }

    public static CarNames from(List<String> names) {
        CarNames carNames = new CarNames();
        carNames.names = names;
        return carNames;
    }

    public List<String> getCarNames() {
        return names;
    }

    public List<String> getNames() {
        return names;
    }
}
