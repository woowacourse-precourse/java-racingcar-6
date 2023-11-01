package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.enums.ErrorMessage;
import racingcar.enums.GameConstant;

public class Generator {
    public List<String> convertStringToStringList(String origin) {
        String divider = GameConstant.DELIMITER.getContent();

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
        Matcher numberMatcher = GameConstant.NUMBER_PATTERN.matcher(origin);

        if (numberMatcher.matches() == false) {
            throw new IllegalArgumentException(ErrorMessage.ATTEMPS_STRING_TO_INTEGER.getMessage());
        }
    }
}