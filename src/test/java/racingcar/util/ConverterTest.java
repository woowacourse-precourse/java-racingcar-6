package racingcar.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {
    @Test
    void 문자열_리스트_변환() {
        // given
        String names = "pobi,woni,test";

        // when
        List<String> carNames = Converter.getCarNames(names);

        // then
        assertThat(carNames.size()).isEqualTo(3);
        assertThat(carNames.contains("pobi")).isTrue();
    }
}
