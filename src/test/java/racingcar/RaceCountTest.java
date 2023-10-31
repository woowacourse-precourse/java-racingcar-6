package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.utils.ErrorMessages.REPEAT_COUNT_NOT_ZERO;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.domain.RaceCount;

@DisplayName("RepeatCount 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RaceCountTest {

    @Test
    void 생성자는_0이_주어지면_예외를_던진다() {
        Assertions.assertThatThrownBy(() -> new RaceCount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(REPEAT_COUNT_NOT_ZERO);
    }

    @Test
    void isRunable_메소드는_count가_0보다_크면_true를_반환한다() {
        RaceCount raceCount = new RaceCount(3);

        assertEquals(raceCount.isRunable(), true);
    }

    @Test
    void isRunable_메소드는_count가_0이면_false를_반환한다() {
        RaceCount raceCount = new RaceCount(1);
        raceCount.disCount();

        assertEquals(raceCount.isRunable(), false);
    }
}
