package Service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomGenerateTest {
    @Test
    @DisplayName("min ~ max 사이 값 반환")
    public void generateNum() {
        //given
        int min = 0;
        int max = 9;

        //when
        RandomGenerate randomGenerate = new RandomGenerate(min, max);
        int generate = randomGenerate.generate();

        //then
        Assertions.assertThat(generate).isBetween(min, max);
    }
}