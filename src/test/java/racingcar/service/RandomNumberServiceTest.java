package racingcar.service;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.constants.RacingCarConstants.RANDOM_MAX;
import static racingcar.constants.RacingCarConstants.RANDOM_MIN;

class RandomNumberServiceTest {
    @RepeatedTest(100)
    void generateRandomNumberTest() {
        // given
        RandomNumberService randomNumberService = new RandomNumberService();

        // when
        int result = randomNumberService.generateRandomNumber();

        // then
        assertTrue(result >= RANDOM_MIN.getValue() && result <= RANDOM_MAX.getValue(),
                "생성된 난수는 지정된 범위 내에 있어야 합니다.");
    }
}