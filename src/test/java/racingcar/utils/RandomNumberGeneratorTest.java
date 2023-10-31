package racingcar.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    
    @DisplayName("랜덤 숫자를 생성하여 반환한다.")
    @Test
    void generate_Success() {
        // given
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        // when, then
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                () -> {
                    int generatedNumber = numberGenerator.generate();
                    Assertions.assertThat(generatedNumber).isEqualTo(4);
                },
                4
        );
    }

}