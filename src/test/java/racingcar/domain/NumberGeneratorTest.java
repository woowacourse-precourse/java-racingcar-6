package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {
    @DisplayName("랜덤 번호 생성 테스트")
    @Test
    void createRandomNumberTest() {
        // 0~9 사이 번호인지 테스트
        NumberGenerator num = new NumberGenerator();
        int randomNumber = num.createRandomNumber();

        assertTrue(randomNumber <= 9 && randomNumber >= 0);
    }
}