package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Domain.RandomNumber;

import static org.assertj.core.api.Assertions.*;

public class RandomNumberTest {

    @Test
    @DisplayName("0 ~ 9 사이 무작위 값 생성 테스트")
    void chooseRandomNumber() {
        assertThat(RandomNumber.chooseRandomNumber())
                .isLessThan(10)
                .isGreaterThan(-1);
    }
}
