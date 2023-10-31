package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberGenerator;

class NumberGeneratorTest {
    @DisplayName("0 ~ 9까지 무작위 생성 테스트")
    @Test
    void generateRandomNumberTest() {
        Set<Integer> generatedNumbers = new HashSet<>();
        NumberGenerator numberGenerator = new NumberGenerator();

        while (true) {
            int generatedNumber = numberGenerator.generateRandomNumber();
            assertTrue(generatedNumber >= NumberGenerator.MIN_NUMBER && generatedNumber <= NumberGenerator.MAX_NUMBER);
            generatedNumbers.add(generatedNumber);
            if (generatedNumbers.size() == 10) {
                break;  // 0 ~ 9까지 적어도 한 번 생성됐으면 테스트 종료
            }
        }
        assertTrue(generatedNumbers.size() == 10);
    }
}