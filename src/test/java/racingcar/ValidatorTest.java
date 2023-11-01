package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.utils.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    @Test
    void 실행횟수가_1미만일_경우_에러() {
        int numOfExecutions = -1;

        assertThatThrownBy(() -> Validator.validateRangeOfExecutions(numOfExecutions))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 실행횟수가_1000초과일_경우_에러() {
        int numOfExecutions = 1001;

        assertThatThrownBy(() -> Validator.validateRangeOfExecutions(numOfExecutions))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_5자_초과일_경우_에러() {
        String name = "asdfgh";

        assertThatThrownBy(() -> Validator.validateCarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
