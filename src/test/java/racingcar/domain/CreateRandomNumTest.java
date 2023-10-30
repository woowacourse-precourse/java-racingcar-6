package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateRandomNumTest {
    private CreateRandomNum createRandomNum;

    @BeforeEach
    void setUp() {
        createRandomNum = new CreateRandomNum();
    }

    @DisplayName("0에서 9까지의 정수 중 한 개의 정수 반환.")
    @Test
    void createRanOneNumTest() {
        // given
        int testCount = 1000;
        int result = 0;

        // when
        for (int i = 0; i < testCount; i++) {
            result = createRandomNum.createRanOneNum();

            // then
            assertTrue(result >= 0 && result <= 9);
        }
    }
}