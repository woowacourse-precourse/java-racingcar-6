package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberOfAttemptsTest {

    @Test
    void 입력_받은_시도_횟수_숫자로_변환() {
        NumberOfAttempts numberOfAttempts = new NumberOfAttempts("5");
        Assertions.assertThat(numberOfAttempts.getNumberOfAttempts()).isEqualTo(5);
    }

}