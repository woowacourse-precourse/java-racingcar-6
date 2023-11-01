package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class JudgmentTest {

    @Test
    void 자동차_이름은_쉼표를_기준으로_구분() {
        String input = "pobi,woni,jun";
        Judgment judgment = new Judgment();
        String[] result = judgment.getSplitCarNames(input);

        assertThat(result).contains("jun", "pobi", "woni");
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 자동차_이름_5자_이상_예외_발생() {
        String[] input = {"pobi,woni,jun"};
        Judgment judgment = new Judgment();

        assertThatThrownBy(() -> judgment.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("car name length out of range: 5");
    }
}
