package racingcar.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Splitter {
    //자동차 이름은 쉼표(,)를 기준으로 구분한다.
    public List<String> stringToList(String carNameLine) {
        List<String> list = Arrays.asList(carNameLine.split(","));

        return list;
    }

    public Map<String, Integer> listToMap(List<String> list) {
        Map<String, Integer> resultMap = new HashMap<>();

        for (String element : list) {
            resultMap.put(element, 0);
        }

        return resultMap;
    }
}
