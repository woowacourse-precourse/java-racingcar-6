package study.domain;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.model.Validator;

public class AttemptCountTest {
    @Test
    void 시도할_횟수_숫자_예외처리() {
        String attemptCount = "ㅇ";

        assertThatThrownBy(() -> {
            Validator.checkNumber(attemptCount);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도할_횟수_양수_예외처리() {
        Integer attemptCount = -1;

        assertThatThrownBy(() -> {
            Validator.isPositiveNum(attemptCount);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
