package study.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.model.RoundCountInput;


class RoundCountInputTest {

    @Test
    void test_정상적인경우() {
        // given
        String input = "5";

        // when
        RoundCountInput roundCountInput = new RoundCountInput(input);
        int roundCount = roundCountInput.getRoundCount();

        // then
        assertThat(roundCount).isEqualTo(5);
    }

    @Test
    void test_빈_입력() {
        // given
        String input = "";

        // when

        // then
        assertThatThrownBy(() -> new RoundCountInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차수의 형식이 이상합니다.");
    }

    @Test
    void test_숫자가_아닌_문자() {
        // given
        String input = "a";

        // when

        // then
        assertThatThrownBy(() -> new RoundCountInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차수의 형식이 이상합니다.");
    }

    @Test
    void test_0인_차수() {
        // given
        String input = "0";

        // when

        // then
        assertThatThrownBy(() -> new RoundCountInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차수는 0보다 큰 수여야 합니다.");
    }

    @Test
    void test_0보다_작은_차수() {
        // given
        String input = "-1";

        // when

        // then
        assertThatThrownBy(() -> new RoundCountInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차수는 0보다 큰 수여야 합니다.");
    }
}