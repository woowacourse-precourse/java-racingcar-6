package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.fail;

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

    @Test
    void 라운드진행_정상진행되는지() {
        Car obj1 = new Car("npc1");
        Car obj2 = new Car("npc2");
        Game gameObj = new Game();

        gameObj.carList.add(obj1);
        gameObj.carList.add(obj2);
        gameObj.roundNumber = 5;

        try {
            gameObj.proceedEachRound();
        } catch (Exception e) {
            fail("proceedEachRound 함수의 실행이 정상적으로 처리되지 않았음");
        }
    }
}
