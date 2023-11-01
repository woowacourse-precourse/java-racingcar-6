package racingcar.validator;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    void length_지정된_길이보다_긴_이름이_주어지면_예외_발생() {
        Integer maxLengthThree = 3;
        String inputLengthThree = "aaa";
        String inputLengthNine = "aaaaaaaaa";

        // 최대 3자리일 때 입력이 3자리면 예외 미발생
        assertThatNoException().isThrownBy(() -> InputValidator.checkNameLengthIsOverflow(inputLengthThree, maxLengthThree));

        // 최대 3자리일 때 입력이 9자리면 예외 발생
        assertThatThrownBy(()->InputValidator.checkNameLengthIsOverflow(inputLengthNine,maxLengthThree))
                .isInstanceOf(IllegalArgumentException.class);
    }

    void positive_양수가_아니면_예외_발생() {
        String inputPlusOne = "1";
        String inputZero = "0";
        String inputMinusOne = "-1";

        // 양수 1 입력했을 때 예외 미발생
        assertThatNoException().isThrownBy(() -> InputValidator.checkRepetitionIsNonNegative(inputPlusOne));

        // 0 입력했을 때 예외 미발생
        assertThatNoException().isThrownBy(() -> InputValidator.checkRepetitionIsNonNegative(inputZero));

        // -1 입력했을 때 예외 발생
        assertThatThrownBy(()->InputValidator.checkRepetitionIsNonNegative(inputMinusOne))
                .isInstanceOf(IllegalArgumentException.class);
    }

    void isInteger_숫자가_아니면_예외_발생() {
        String inputInteger = "1234";
        String inputString = "string";

        // 숫자 입력했을 때 예외 미발생
        assertThatNoException().isThrownBy(() -> InputValidator.checkRepetitionIsInteger(inputInteger));

        // 문자 입력했을 때 예외 발생
        assertThatThrownBy(()->InputValidator.checkRepetitionIsInteger(inputString))
                .isInstanceOf(IllegalArgumentException.class);

    }

}
