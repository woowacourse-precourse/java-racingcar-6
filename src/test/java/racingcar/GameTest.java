package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

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
}
