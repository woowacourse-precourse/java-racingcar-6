package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.GenerateRandomNumber;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputTest {
    @Test
    @DisplayName("랜덤 숫자 생성 테스트")
    void 랜덤_숫자_생성_테스() {
        GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();

        for (int i = 0; i < 1000; i++) {    // 1000번 테스트
            int randomNum = generateRandomNumber.generate();
            assertThat(randomNum).isBetween(0, 9);
        }
    }
}
