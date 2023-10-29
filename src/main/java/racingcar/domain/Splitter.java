package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class Splitter {
    //자동차 이름은 쉼표(,)를 기준으로 구분한다.
    public List<String> stringToList(String carNameLine) {
        List<String> list = Arrays.asList(carNameLine.split(","));

        return list;
    }
}
