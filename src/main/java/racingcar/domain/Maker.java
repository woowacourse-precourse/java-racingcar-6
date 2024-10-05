package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Maker {

    private final String Members;

    public Maker(String Members) {
        this.Members = Members;
    }

    public Map<String, Integer> makeMap() {
        Map<String, Integer> map = new LinkedHashMap<>();
        String[] names = Members.split(",");
        for (String name : names) {
            map.put(name, 0);
        }
        return map;
    }
}
