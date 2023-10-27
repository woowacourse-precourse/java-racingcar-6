package racingcar.domain;

import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class AskCarNameTest {

    @Test
    void 구분자_포함_확인_구분자없는경우() {
        String input = "test";
        Map<String, Integer> result = new HashMap<>();
        result.put(input, 0);

        assertThat(result).containsKey(input);
        assertThat(result).containsValue(0);
        assertThat(result).containsExactlyEntriesOf(result);
    }

    @Test
    void 구분자_포함_확인_구분자있는경우() {
        String input = "test,game,play";
        String[] splitInput = input.split(",");
        Map<String, Integer> result = new HashMap<>();

        for (String str : splitInput) {
            result.put(str, 0);
        }

        for (String checkKey : splitInput){
            assertThat(result).containsKey(checkKey);
            assertThat(result).containsValue(0);
        }

    }
}
