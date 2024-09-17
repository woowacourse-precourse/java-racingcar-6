package racingcar.common;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConverterTest {

    @Test
    void 문자_LinkedHashMap으로_변환_테스트(){
        String input = "1,2,3,4";
        Map<String, Integer> result = Converter.stringToMap(input);

        Map<String, Integer> expect = new LinkedHashMap<>();
        expect.put("1", 0);
        expect.put("2", 0);
        expect.put("3", 0);
        expect.put("4", 0);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 문자_LinkedHashMap으로_변환_key값_중복_예외_테스트(){
        String input = "pobi,anti,pobi";

        assertThatThrownBy(() -> Converter.stringToMap(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("중복된 자동차 이름이 존재합니다.");
    }

    @Test
    void 문자_Integer로_변환_테스트(){
        String input = "5";
        int result = Converter.stringToInteger(input);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void 문자_Integer로_변환_숫자아닐시_예외_테스트(){
        String input = "5번";

        assertThatThrownBy(() -> Converter.stringToInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
    }
}
