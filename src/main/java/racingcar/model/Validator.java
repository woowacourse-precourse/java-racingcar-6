package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public boolean isNumberic(String inputValue) {
        return inputValue.matches("[+-]?\\d*(\\.\\d+)?");
    }

    public boolean isUniqueName(List<String> nameList) {
        Set<String> set = new HashSet<>();

        for (String name : nameList) {
            if (!set.add(name)) return false;
        }
        return true;
    }
}
