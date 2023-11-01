package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundCountTest {

    @Test
    void 생성자로_생성_성공시_String을_int로_변환() {
        RoundCount roundCount = new RoundCount("5");
        assertThat(roundCount.getRoundCount())
                .isEqualTo(5);
    }

    @Test
    void 숫자가_아닌_경우_생성자로_생성_실패시_에러() {
        assertThatThrownBy(() -> new RoundCount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("라운드 횟수가 숫자가 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "-3", "0" })
    void zero이하인경우_생성자로_생성_실패시_에러(String input) {
        assertThatThrownBy(() -> new RoundCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("라운드 횟수는 1 이상이어야 합니다.");
    }
}