package racingcar;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.util.InputValidator;

public class InputValidatorTest {
    private static final String NUMBER_REGEX = "[1-9]+";
    private static final String ENGLISH_REGEX = "^[a-zA-Z]*$";
    private static final int NAME_MAX_LENGTH_CONDITION = 5;
    private static final int NAME_MIN_LENGTH_CONDITION = 0;

    @Test
    void isNumber() {
        String inputNumber = "123";
        String inputWrongNumber = "123d";

        assertThat(inputNumber.matches(NUMBER_REGEX)).isEqualTo(true);
        assertThat(inputWrongNumber.matches(NUMBER_REGEX)).isEqualTo(false);
    }

    @Test
    void isEnglish() {
        String inputEnglish = "brown";
        String inputWrongEnglish = "brow12";

        assertThat(inputEnglish.matches(ENGLISH_REGEX)).isEqualTo(true);
        assertThat(inputWrongEnglish.matches(ENGLISH_REGEX)).isEqualTo(false);
    }

    @Test
    void checkLengthCondition() {
        int[] nameLengthList = {"brown".length(), "".length(), "browny".length()};
        boolean[] expectReturn = {true, false, false};

        for(int i=0; i<nameLengthList.length; i++) {
            assertThat(isLengthCondition(nameLengthList[i])).isEqualTo(expectReturn[i]);
        }
    }

    boolean isLengthCondition(int inputLength) {
        return inputLength <= NAME_MAX_LENGTH_CONDITION && inputLength > NAME_MIN_LENGTH_CONDITION;
    }
}
