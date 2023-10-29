package racingcar;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.util.Converter;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {

    private static final Converter converter = new Converter();

    @Test
    void 문자열_리스트_변환() {
        // given
        String names = "pobi,woni,test";

        // when
        List<String> carNames = converter.getCarNames(names);

        // then
        assertThat(carNames.size()).isEqualTo(3);
        assertThat(carNames.contains("pobi")).isTrue();
    }
}
