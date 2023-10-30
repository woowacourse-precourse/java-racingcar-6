package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.enums.ErrorMessage;
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
        validateConvertStringToInteger(origin);

        return Integer.parseInt(origin);
    }

    public Integer generateRandomValue0To9() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void validateConvertStringToInteger(String origin) {
        String numbersPattern = GameConstant.NUMBERS.getContent();

        if (origin.matches(numbersPattern) == false) {
            throw new IllegalArgumentException(ErrorMessage.ATTEMPS_STRING_TO_INTEGER.getMessage());
        }
    }
}