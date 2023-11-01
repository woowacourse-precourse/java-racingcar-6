package racingcar.game;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {

    @Test
    void 시도회수를_생성한다() {
        // given
        TryCount tryCount = new TryCount("5");

        // then
        Assertions.assertThat(tryCount).isEqualTo(new TryCount("5"));
    }

    @Test
    void 게임을_진행한다() {
        // given
        TryCount tryCount = new TryCount("2");

        // when
        tryCount.tried();

        // then
        Assertions.assertThat(tryCount).isEqualTo(new TryCount("1"));
    }

    @ParameterizedTest
    @CsvSource(value = {"2,true", "1,false"})
    void 게임을_더_진행할지_알_수_있다(String tryCount, boolean expected) {
        // given
        TryCount count = new TryCount(tryCount);

        // when
        count.tried();
        boolean actual = count.isMoreTry();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "", "0"})
    void 잘못된_값을_입력하면_예외가_발생한다(String tryCount) {
        // when
        assertThrows(IllegalArgumentException.class, () ->
                new TryCount(tryCount));
    }
}
