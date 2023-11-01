package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {
    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @Test
    @DisplayName("랜덤 숫자 생성 테스트")
    void 랜덤_숫자_생성_테스트() {
        int randomNumber = numberGenerator.createRandomNumber();
        assertThat(randomNumber).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);
    }
}