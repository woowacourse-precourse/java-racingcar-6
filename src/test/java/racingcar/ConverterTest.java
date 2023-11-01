package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.utils.Converter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {
    @Test
    void 문자열을_List로_변환() {
        // given
        String names = "apple, banana, cherry";
        //when
        List<String> nameList = Converter.toList(names);
        // then
        assertThat(nameList).containsExactly("apple", "banana", "cherry");
    }
}
