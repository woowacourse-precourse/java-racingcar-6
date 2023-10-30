package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.enums.GameConstant;

public class Generator {
    public List<String> convertStringToStringList(String origin) {
        String divider = GameConstant.DIVIDER.getContent();

        List<String> result = new ArrayList<>();

        for (String originItem : origin.split(divider)) {
            result.add(originItem);
        }

        return result;
    }

    public Integer convertStringToInteger(String origin) {
        return Integer.parseInt(origin);
    }
}