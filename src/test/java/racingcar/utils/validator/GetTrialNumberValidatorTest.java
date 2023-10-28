package racingcar.utils.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import javax.xml.validation.Validator;
import org.junit.jupiter.api.Test;
import racingcar.utils.Converter;

class GetTrialNumberValidatorTest {

    public int trialNumberTestMethod(String input){
        int i = Converter.convertStringToInt(input);
        GetTrialNumberValidator.validateNumberRange(i);
        return 1;
    }
    @Test
    void 시도횟수_0이하_예외처리() {
        String input = "-1";

        assertThatThrownBy(() -> trialNumberTestMethod(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 100");
    }

    @Test
    void 시도횟수_100초과_예외처리() {
        String input = "101";

        assertThatThrownBy(() -> trialNumberTestMethod(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 100");
    }

    @Test
    void 시도횟수_not_숫자_예외처리() {
        String input = "a";

        assertThatThrownBy(() -> trialNumberTestMethod(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자");
    }

    @Test
    void 시도횟수_공백_예외처리() {
        String input = "101";

        assertThatThrownBy(() -> trialNumberTestMethod(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자");
    }

}