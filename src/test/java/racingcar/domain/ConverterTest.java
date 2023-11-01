package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @Test
    void 문자열_리스트를_Car_리스트로_변환() {
        final Converter converter = new Converter();
        List<String> input = new ArrayList<>();
        input.add("가나다라마바사");
        input.add("abc");

        List<Car> result = converter.nameListToCarList(input);

        assertThat(result).containsExactly(new Car("가나다라마바사"), new Car("abc"));
        assertThat(result.size()).isEqualTo(2);
    }
}
