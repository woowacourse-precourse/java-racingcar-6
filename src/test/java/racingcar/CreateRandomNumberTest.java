package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateRandomNumberTest {
    @Test
    void 랜덤숫자_범위() {
        // given
        final int randomNumber = CreateRandomNumber.getNumber();

        // when
        boolean isInRange = 0 < randomNumber && randomNumber < 9;

        // then
        Assertions.assertThat(isInRange).isTrue();
    }
}