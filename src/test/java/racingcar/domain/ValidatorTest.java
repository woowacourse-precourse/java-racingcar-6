package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    void validator_자동차이름_중에서_6글자_이상인_이름_존재시_예외_발생() {
        List<String> invalidCarNames = Arrays.asList("valid1", "valid2", "invalidName");

        assertThatThrownBy(() -> validator.validateCarNameLength(invalidCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 값을 입력하여 게임을 종료하겠습니다.");
    }


    @Test
    void validator_입력값이_비어있는_경우_예외_발생() {
        String input = "";

        assertThatThrownBy(() -> Validator.valideteIsEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 비어있습니다.");
    }

    @Test
    void validator_입력_값이_문자열인_경우_예외_발생() {
        String input = "s";

        assertThatThrownBy(() -> validator.validateIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 유효한 숫자가 아닙니다.");
    }
}