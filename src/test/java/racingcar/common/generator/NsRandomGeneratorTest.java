package racingcar.common.generator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NsRandomGeneratorTest {
    @Test
    public void generate_메서드_테스트() {
        RandomGenerator generator = NsRandomGenerator.of();
        for (int i = 0; i < 100; i++) {
            int result = generator.generate();
            Assertions.assertTrue(result >= 0 && result <= 9);
        }
    }

}
