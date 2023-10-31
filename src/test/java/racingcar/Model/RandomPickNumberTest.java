package racingcar.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class RandomPickNumberTest {
    @Test
    void 랜덤한_숫자_확인() {
        for (int i = 0; i < 100; i++) {
            int randomNumber = RandomPickNumber.getRandomPickNumber();
            assertThat(randomNumber).isGreaterThanOrEqualTo(0);
            assertThat(randomNumber).isLessThanOrEqualTo(10);
        }
    }
}
