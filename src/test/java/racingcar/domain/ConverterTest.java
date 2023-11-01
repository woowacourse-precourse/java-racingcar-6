package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {

    @Test
    void 문자열을_구분자로_나누고_리스트로_반환() {
        final Converter converter = new Converter();
        final String input = "1,사과,apple,!@#,-00";
        final String separator = ",";

        List<String> result = converter.separatedStringToList(input, separator);

        assertThat(result).containsExactly("1", "사과", "apple", "!@#", "-00");
        assertThat(result.size()).isEqualTo(5);
    }
}
