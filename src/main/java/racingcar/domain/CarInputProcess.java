package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarInputProcess {
    public List<String> process(String input) {
        String[] inputSplit = input.split(",");

        List<String> cars = new ArrayList<>();

        for(String car : inputSplit) {
            if(car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름의 길이가 5자 초과입니다.");
            }
            cars.add(car);
        }

        return cars;
    }
}
