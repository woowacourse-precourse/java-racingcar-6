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

    @Test
    void isRunable_메소드는_count가_0보다_크면_true를_반환한다() {
        RepeatCount repeatCount = new RepeatCount(3);

        assertEquals(repeatCount.isRunable(), true);
    }

    @Test
    void isRunable_메소드는_count가_0이면_false를_반환한다() {
        RepeatCount repeatCount = new RepeatCount(1);
        repeatCount.disCount();

        assertEquals(repeatCount.isRunable(), false);
    }
}
