package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class NameHandlerTest {
    @Test
    void 입력받은_이름을_쪼개기() {
        List<String> inputs = Arrays.asList("pobi,woni,jun", " ,  ",
                "hi", ",,,", ",a,", "  ");
        List<List<String>> results = Arrays.asList(Arrays.asList("pobi", "woni", "jun"),
                Arrays.asList(" ", "  "), Arrays.asList("hi"), Arrays.asList("", "", "", ""),
                Arrays.asList("", "a", ""), Arrays.asList("  "));

        for (int i = 0; i < inputs.size(); i++) {
            assertThat(NameHandler.splitNames(inputs.get(i))).isEqualTo(results.get(i));
        }
    }
}
