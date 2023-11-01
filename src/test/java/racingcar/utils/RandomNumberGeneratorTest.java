package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("0부터 9까지의 랜덤한 수를 생성한다.")
    void generateRandomNumber0In9() {
        //given //when
        int generatedRandomNumber = RandomNumberGenerator.generate();

        //then
        assertThat(generatedRandomNumber).isBetween(0, 9);
    }
}