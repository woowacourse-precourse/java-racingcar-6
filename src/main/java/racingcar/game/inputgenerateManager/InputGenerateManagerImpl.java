package racingcar.game.inputgenerateManager;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import racingcar.game.enums.NumberSize;
import racingcar.game.exception.IllegalLengthException;
import racingcar.game.exception.IllegalTypeException;

public class InputGenerateManagerImpl implements InputGenerateManager {
    @Override
    public Integer generateRandomInt() {
        return Randoms.pickNumberInRange(NumberSize.START_INCLUSIVE.getSize(), NumberSize.END_INCLUSIVE.getSize());
    }

    @Override
    public Integer generateInputStringToInt(String rawData) {
        validateIsNumeric(rawData);
        return Integer.valueOf(rawData);
    }

    @Override
    public List<String> generateInputStringSplitWithComma(String rawData) {
        String[] splitData = rawData.split(",");
        validateLength(splitData);
        return Arrays.asList(splitData);
    }

    private static void validateIsNumeric(String rawData) {
        if (!rawData.matches("\\d+")) {
            throw new IllegalTypeException();
        }
    }

    private static void validateLength(String[] splitData) {
        for (String string : splitData) {
            if(string.length() >= 5){
                throw new IllegalLengthException();
            }
        }
    }
}
