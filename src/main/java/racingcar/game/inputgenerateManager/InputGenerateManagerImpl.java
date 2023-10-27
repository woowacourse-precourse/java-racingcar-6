package racingcar.game.inputgenerateManager;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import racingcar.game.enums.NumberSize;
import racingcar.game.exception.IllegalLengthException;
import racingcar.game.exception.IllegalNullTypeException;
import racingcar.game.exception.IllegalTypeException;

public class InputGenerateManagerImpl implements InputGenerateManager {
    @Override
    public Integer generateRandomInt() {
        return Randoms.pickNumberInRange(NumberSize.START_INCLUSIVE.getSize(), NumberSize.END_INCLUSIVE.getSize());
    }

    @Override
    public Integer generateInputStringToInt(String rawString) {
        validateIsNull(rawString);
        validateIsNumeric(rawString);
        return Integer.valueOf(rawString);
    }

    @Override
    public List<String> generateInputStringSplitWithComma(String rawString) {
        validateIsNull(rawString);
        String[] splitData = rawString.split(",");
        validateLength(splitData);
        return Arrays.asList(splitData);
    }

    private static void validateIsNumeric(String rawString) {
        if (!rawString.matches("\\d+")) {
            throw new IllegalTypeException();
        }
    }

    private static void validateLength(String[] splitString) {
        for (String string : splitString) {
            if(string.length() > 5){
                throw new IllegalLengthException();
            }
        }
    }

    private static void validateIsNull(String rawString) {
        if (rawString == null || rawString.equals("")) {
            throw new IllegalNullTypeException();
        }
    }
}
