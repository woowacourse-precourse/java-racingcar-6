package racingcar.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.RepeatedTest;

class RandomGeneratorTest {

    @RepeatedTest(100)
    void 무작위_숫자_생성_결과는_0에서_9_사이여야_한다() {
        int generatedNumber = RandomGenerator.generateRandomNumber();

        assertTrue(generatedNumber >= 0 && generatedNumber <= 9,
                "생성된 숫자는 0에서 9 사이여야 하는데, 실제로는: " + generatedNumber + "이(가) 생성되었습니다.");
    }
}