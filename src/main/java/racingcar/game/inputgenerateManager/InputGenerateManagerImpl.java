package racingcar.game.inputgenerateManager;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import racingcar.game.enums.InputSize;

public class InputGenerateManagerImpl implements InputGenerateManager {
    private static final String COMMA_DELIMITER = ",";

    @Override
    public Integer generateRandomInt() {
        return Randoms.pickNumberInRange(InputSize.START_INCLUSIVE.getSize(), InputSize.END_INCLUSIVE.getSize());
    }

    @Override
    public Integer generateInputStringToInt(String rawString) {
        InputValidator.validateNumber(rawString);
        return Integer.valueOf(rawString);
    }

    @Override
    public List<String> generateInputStringSplitWithComma(String rawString) {
        InputValidator.validateIsBlankFromString(rawString);
        String[] splitData = rawString.split(COMMA_DELIMITER);
        InputValidator.validateName(splitData);
        return Arrays.asList(splitData);
    }
}
