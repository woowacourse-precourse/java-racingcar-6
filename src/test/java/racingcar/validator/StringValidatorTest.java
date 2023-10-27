package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringValidatorTest {

    @Test
    void 문자_검증기_테스트() {
        String input = "aaa,bbb";
        InputValidator validator = new StringValidator(input);

        Assertions.assertThatNoException().
                isThrownBy(validator::validate);

    }

    @Test
    void 문자_검증기_실패_테스트() {
        String input = "aaaaaa,bb,cc";
        InputValidator validator = new StringValidator(input);

        Assertions.assertThatIllegalArgumentException().
                isThrownBy(validator::validate);

    }
}
