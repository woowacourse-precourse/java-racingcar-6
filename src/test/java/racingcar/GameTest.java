package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void 자동차이름들_구분자로_구분() {
        String separator = ",";
        String input = "vega,npc";
        String[] result = input.split(separator);

        assertThat(result).contains("npc", "vega");
        assertThat(result).containsExactly("vega", "npc");
    }

    @Test
    void 자동차수가_주어진_최소치보다_작을경우() { //null의 경우는 너무 단순하게 처리되어서 테스트에 포함x
        int minimumLength = 2;
        String input = "vega,npc1";
        String[] result = input.split(",");

        assertThat(result).hasSizeGreaterThanOrEqualTo(minimumLength);
    }

    @Test
    void 자동차이름들_중복검사() {
        String input = "vega,npc1";
        String[] result = input.split(",");
        List<String> resultList = Arrays.asList(result);
        Set<String> resultSet = new HashSet<>(resultList);

        assertThat(resultSet.size()).isEqualTo(result.length);
    }

    @Test
    void validate_라운드횟수_숫자인지() {
        String input = "7a";

        assertThatThrownBy(() -> Integer.parseInt(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("For input string: \"7a\"");
    }

    @Test
    void validate_라운드횟수_null인지() {
        String input = "7";

        assertThat(input).isNotNull();
    }

    @Test
    void validate_라운드횟수_0보다큰지() {
        String input = "1";

        assertThat(Integer.parseInt(input)).isGreaterThan(0);
    }
}
