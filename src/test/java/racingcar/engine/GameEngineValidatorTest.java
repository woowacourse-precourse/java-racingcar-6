package racingcar.engine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameEngineValidatorTest {
    @Test
    public void 플레이어이름이_null값이면_예외를던진다() {
        Assertions.assertThatCode(() -> new GameEngineValidator().validateIsNotNull(null))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 null입니다.");
    }

    @Test
    public void 플레이어이름이_null값이아니면_예외를던지지_않는다() {
        Assertions.assertThatCode(() -> new GameEngineValidator().validateIsNotNull(""))
                .doesNotThrowAnyException();
    }
}