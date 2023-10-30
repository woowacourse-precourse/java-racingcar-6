package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @Test
    @DisplayName("0 ~ 9 범위내 숫자를 랜덤으로 생성")
    void generateNumberTest() {
        //given
        int num;

        //when
        num = RandomNumberGenerator.generateNumber();
        boolean result = (num >= 0 && num <= 9);

        //then
        Assertions.assertThat(result).isEqualTo(true);
    }
}
