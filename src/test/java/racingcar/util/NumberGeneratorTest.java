package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @DisplayName("지정된 범위 내에서 랜덤 숫자를 생성한다.")
    @Test
    void generateRandomNumberInRange() {
        //given
        final int start = 0;
        final int end = 5;

        //when
        int randomNumber = NumberGenerator.generateRandomNumberInRange(start, end);

        //then
        assertThat(randomNumber).isBetween(start, end);
    }

}