package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {
    static NumberGenerator testNG = new NumberGenerator();

    @Test
    void 숫자생성_테스트() {
        int result = testNG.createNumber();
        int min = 0;
        int max = 9;
        assertThat(result >= min && result <= max).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"4,1,false", "4,5,true", "4,4,true",})
    void 숫자비교_테스트(int tagetNum, int compareNum, boolean expected) {
        assertThat(testNG.compareBigger(tagetNum, compareNum)).isEqualTo(expected);
    }

}