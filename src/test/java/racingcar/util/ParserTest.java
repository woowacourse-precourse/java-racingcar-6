package racingcar.util;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.List;

class ParserTest {
    Parser parser = new Parser();
    @Test
    void Round_stringToInt() {
        String input = "123";
        int result = parser.changeStringToInteger(input);
        assertThat(result).isEqualTo(123);
    }
    @Test
    void Round_NumberFormatException() {
        String input = "abc";
        assertThatThrownBy(() -> parser.changeStringToInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력하세요.");
    }
    @Test
    void Round_NumberZeroException() {
        String input = "0";
        assertThatThrownBy(() -> parser.changeStringToInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0값은 라운드가 시작되지 않습니다.");
    }
    @Test
    void Round_Null() {
        String input = "";
        assertThatThrownBy(() -> parser.changeStringToInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈값은 라운드가 시작되지 않습니다.");
    }
    @Test
    void carName_ChangeList() {
        String input = "nari,jin,kim";
        List<String> result = parser.getSplitString(input);
        assertThat(result).contains("jin", "nari", "kim");
        assertThat(result).containsExactly("nari", "jin", "kim");
    }
    @Test
    void carName_Space_Exception() {
        String input = "nari, jin";
        assertThatThrownBy(() -> parser.getSplitString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백없이 입력하세요.");
    }
    @Test
    void carName_Max5() {
        String input = "nari,youjin";
        assertThatThrownBy(() -> parser.getSplitString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~5글자의 자동차 이름을 입력하세요.");
    }
    @Test
    void carName_Null() {
        String input = "";
        assertThatThrownBy(() -> parser.getSplitString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈값은 라운드가 시작되지 않습니다.");
    }
}