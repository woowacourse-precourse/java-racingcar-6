package racingcar.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;

public class TurnNumInputValidatorTest extends NsTest {
    private static final String ASK_INT_UNDER_PROPER_AMOUNT = "잘못된 입력입니다. 적정한 수를 정수 형태로 입력해주세요";
    private static final String ASK_POSITIVE_NUM_INPUT = "잘못된 입력입니다. 0이상의 수를 입력해주세요";

    TurnNumInputValidator validator = new TurnNumInputValidator();

    @ParameterizedTest
    @ValueSource(strings = {"테스트", "1000000000000", "*1", "***"})
    @DisplayName("문자, 특수문자, 큰 수 입력 예외 처리 테스트")
    void 문자_큰수_입력_예외_처리_테스트(String input) {
        assertThatThrownBy(
                () -> {
                    validator.isInputDigit(input);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_INT_UNDER_PROPER_AMOUNT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    @DisplayName("음수, 영값 입력 예외 처리 테스트")
    void 음수_영값_입력_예외_처리_테스트(String input) {
        assertThatThrownBy(
                () -> {
                    validator.isPositive(input);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_POSITIVE_NUM_INPUT);
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
