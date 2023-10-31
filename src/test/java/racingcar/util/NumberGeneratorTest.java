package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import generator.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("범위안의 수를 생성한다.")
    void should_GenerateNumber1To9(int number) {
        NumberGenerator generator = new NumberGenerator(number);
        int num = generator.getNumber();
        assertThat(num).isEqualTo(number);
    }
}
