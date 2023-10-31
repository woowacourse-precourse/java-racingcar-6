package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class UtilTest {
    @Test
    void 문자열_공백_제거_테스트() {
        String input = "띄 어 쓰 기";
        String result = Util.removeSpaceAll(input);
        assertThat(result).isEqualTo("띄어쓰기");
    }

    @Test
    void 쉼표로_문자열_구분_테스트() {
        String input = "안녕하세요, one, two 2, 띄 어 쓰 기";
        List<String> results = Util.splitNameByComma(input);
        assertThat(results).contains("안녕하세요", "one", "two2", "띄어쓰기");
    }
}