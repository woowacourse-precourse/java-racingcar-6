package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ForwardCheckerTest {

    private ForwardChecker forwardChecker;

    @BeforeEach
    void setUp() {
        forwardChecker = new ForwardChecker();
    }

    @Test
    void 숫자_4이상인_경우_true를_반환() {
        for (int number = 4; number < 10; number++) {
            Boolean isForward = forwardChecker.checkIfForward(number);
            assertThat(isForward).isTrue();
        }
    }

    @Test
    void 숫자_4미만인_경우_false를_반환() {
        for (int number = 0; number < 4; number++) {
            Boolean isForward = forwardChecker.checkIfForward(number);
            assertThat(isForward).isFalse();
        }
    }
}