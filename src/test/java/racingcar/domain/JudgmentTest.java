package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class JudgmentTest {
    @Test
    void 전진여부_판단_4이상() {
        int testNumber = 5;
        Judgment judgment = new Judgment();
        boolean isMove = judgment.canMove(testNumber);
        Assertions.assertThat(isMove).isEqualTo(Boolean.TRUE);
    }

    @Test
    void 전진여부_판단_4미만() {
        int testNumber = 3;
        Judgment judgment = new Judgment();
        boolean isMove = judgment.canMove(testNumber);
        Assertions.assertThat(isMove).isEqualTo(Boolean.FALSE);
    }
}