package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @DisplayName("[generateRandomNumber] generateRandomNumber() 테스트")
    @Test
    public void 랜덤수_생성하기_테스트() {
        // Given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        // When
        int randomNumber = randomNumberGenerator.generateRandomNumber();
        // 반환된 무작위 숫자가 범위 내에 있는지 검증
        assertThat(randomNumber).isBetween(0, 9);
    }

}