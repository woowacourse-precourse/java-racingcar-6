package racingcar.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.GameUtil;
import racingcar.view.InputView;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RoundValidatorTest {
    private RoundValidator roundValidator;

    private final static String NOT_NUMBER_ERROR_MESSAGE = "숫자를 입력해주세요.";
    private final static String NUMBER_WILL_MORE_THAN_ONE = "1이상의 라운드를 숫자로 입력해주세요";

    @Test()
    void 진행_라운드_숫자_외_문자_입력_예외_처리() {
        assertThatThrownBy(() -> roundValidator = new RoundValidator("asd"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMBER_ERROR_MESSAGE);
    }

    @Test()
    void 진행_라운드_미_입력_예외_처리() {
        assertThatThrownBy(() -> roundValidator = new RoundValidator(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMBER_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-100"})
        // 여러 입력값
    void 진행_라운드_1_미만_입력_예외_처리(String input) {
        assertThatThrownBy(() -> new RoundValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_WILL_MORE_THAN_ONE);
    }

    @Test
    void 사용자_입력_라운드_반환_테스트() {
        String input = "3";
        int repeatNum = GameUtil.setRepeatCount(input);
        assertThat(repeatNum).isEqualTo(3);
    }
}
