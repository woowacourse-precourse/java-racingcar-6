package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InputTest {

    @Test
    public void 테스트_모두_유효한_자동차이름() {
        // given
        String inputCarNames = "우아,한,테크,코스";
        //then
        assertDoesNotThrow(() -> ValidationManager.validateCarNames(inputCarNames));
    }

    @Test
    public void 테스트_5자_초과_자동차이름() {
        // given
        String inputCarNames = "우아,하아안,테크으으으으,코스으으으으";
        // then
        assertThatThrownBy(() -> ValidationManager.validateCarNames(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 테스트_공백포함() {
        //given
        String inputCarNames = "우아, ,한,테크";
        // then
        assertThatThrownBy(() -> ValidationManager.validateCarNames(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class);    }
}
