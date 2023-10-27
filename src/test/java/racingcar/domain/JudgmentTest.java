package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class JudgmentTest {

    @Test
    void isMoreThanFour() {
        Judgment judgment = new Judgment();
        Assertions.assertThat(judgment.isMoreThanFour(4)).isTrue();
    }
}