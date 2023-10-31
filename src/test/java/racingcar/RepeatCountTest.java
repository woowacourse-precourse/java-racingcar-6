package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.utils.ErrorMessages.REPEAT_COUNT_NOT_ZERO;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.domain.RepeatCount;

@DisplayName("RepeatCount 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RepeatCountTest {

    @Test
    void 생성자는_0이_주어지면_예외를_던진다() {
        Assertions.assertThatThrownBy(() -> new RepeatCount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(REPEAT_COUNT_NOT_ZERO);
    }
}
