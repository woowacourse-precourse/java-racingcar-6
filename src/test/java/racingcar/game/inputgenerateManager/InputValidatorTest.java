package racingcar.game.inputgenerateManager;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.game.exception.IllegalBlankException;
import racingcar.game.exception.IllegalDuplicateException;
import racingcar.game.exception.IllegalLengthException;
import racingcar.game.exception.IllegalRangeException;
import racingcar.game.exception.IllegalTypeException;

class InputValidatorTest {

    private final static String ONLY_STRING = "onlyString";
    private final static String OVER_VALUE = "99999999999999999";
    private final static String ONLY_BLANK = " ";
    private final static String[] NAME_LIST_CONTAIN_OVER_LENGTH = {"한놈", "두식이", "다섯글자이상"};
    private final static String[] NAME_LIST_CONTAIN_SPACE = {"한놈", "두식이", " "};
    private final static String[] NAME_LIST_CONTAIN_DUPLICATE_NAME = {"한놈", "두식이", "한놈"};

    @Test
    void 숫자검증() {
        Assertions.assertThatThrownBy(() -> InputValidator.validateNumber(ONLY_STRING))
                .isInstanceOf(IllegalTypeException.class);
        Assertions.assertThatThrownBy(() -> InputValidator.validateNumber(ONLY_BLANK))
                .isInstanceOf(IllegalTypeException.class);
        Assertions.assertThatThrownBy(() -> InputValidator.validateNumber(OVER_VALUE))
                .isInstanceOf(IllegalRangeException.class);
    }

    @Test
    void 이름검증() {
        Assertions.assertThatThrownBy(() -> InputValidator.validateName(NAME_LIST_CONTAIN_OVER_LENGTH))
                .isInstanceOf(IllegalLengthException.class);
        Assertions.assertThatThrownBy(() -> InputValidator.validateName(NAME_LIST_CONTAIN_SPACE))
                .isInstanceOf(IllegalBlankException.class);
        Assertions.assertThatThrownBy(() -> InputValidator.validateName(NAME_LIST_CONTAIN_DUPLICATE_NAME))
                .isInstanceOf(IllegalDuplicateException.class);
    }
}