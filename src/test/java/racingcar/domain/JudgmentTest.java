package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JudgmentTest {

    @Test
    void isMoreThanFour() {
        Judgment judgment = new Judgment();
        assertThat(judgment.isMoreThanFour(4)).isTrue();
        assertThat(judgment.isMoreThanFour(3)).isFalse();
    }
}