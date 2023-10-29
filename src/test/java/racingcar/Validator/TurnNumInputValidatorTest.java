package racingcar.Validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class TurnNumInputValidatorTest extends NsTest {
    private final String ASK_NUMBER_INPUT = "잘못된 입력입니다. 숫자를 입력해야 합니다";
    private final String ASK_POSITIVE_NUM_INPUT = "잘못된 입력입니다. 0이상의 수를 입력해주세요";

    @Test
    @DisplayName("턴 횟수 반환 테스트")
    void 턴_횟수_반환_테스트() {

        TurnNumInputValidator turnNumInputValidator = new TurnNumInputValidator("5");

        assertThat(turnNumInputValidator.getTurnNumberInputInt())
                .isEqualTo(5);
    }

    @Test
    @DisplayName("문자 입력 예외 처리 테스트")
    void 문자_입력_예외_처리_테스트() {

        TurnNumInputValidator turnNumInputValidator = new TurnNumInputValidator("테스트");
        assertThatThrownBy(() -> {
            turnNumInputValidator.validate();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_NUMBER_INPUT);
    }

    @Test
    @DisplayName("음수 입력 예외 처리 테스트")
    void 음수_입력_예외_처리_테스트() {

        TurnNumInputValidator turnNumInputValidator = new TurnNumInputValidator("-13");
        assertThatThrownBy(() -> {
            turnNumInputValidator.validate();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_POSITIVE_NUM_INPUT);
    }

    @Test
    @DisplayName("0입력 예외 처리 테스트")
    void 영값_입력_예외_처리() {

        TurnNumInputValidator turnNumInputValidator = new TurnNumInputValidator("0");
        assertThatThrownBy(() -> {
            turnNumInputValidator.validate();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ASK_POSITIVE_NUM_INPUT);
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}