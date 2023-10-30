package racingcar.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.exception.NonPositiveIntException;

class TryCountTest {

    @CsvSource({"-1", "0", "as"})
    @ParameterizedTest
    void 입력이_1이상의_정수가_아니라면_예외가_발생한다(String count) {
        // when & then
        assertThatThrownBy(() -> TryCount.from(count))
                .isInstanceOf(NonPositiveIntException.class);
    }

    @Test
    void 시도횟수가_감소한다() {
        // given
        TryCount tryCount = TryCount.from("1");

        // when
        tryCount.decrease();

        // then
        assertThat(tryCount.isEnd()).isTrue();
    }

    @Test
    void 동일한_횟수를_가진_TryCount_인스턴스는_동등하다() {
        // given
        TryCount result = TryCount.from("1");
        TryCount expected = TryCount.from("1");

        // When & Then
        assertThat(result).isEqualTo(expected)
               .hasSameHashCodeAs(expected);
    }
}
