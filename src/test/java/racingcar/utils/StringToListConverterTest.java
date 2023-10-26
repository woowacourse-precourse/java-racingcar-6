package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class StringToListConverterTest {

    @Test
    @DisplayName("입력된 문자열을 쉼표(,)를 기준으로 분리할 수 있다.")
    void convert() {
        Converter<String, List<String>> converter = new StringToListConverter();
        List<String> result = converter.convert("pobi,woni,jun");

        assertThat(result).containsExactly("pobi", "woni", "jun");
    }
}