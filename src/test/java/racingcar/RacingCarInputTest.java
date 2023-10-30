package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarInputTest {
    @Test
    void 콤마_단위로_리스트에_나누는_기능() {
        String input = "a,b,c";
        String input2 = "a, b, c";
        String input3 = ",a,b";
        List<String> result = Arrays.asList(input.split(","));
        List<String> result2 = Arrays.asList(input2.split(","));
        List<String> result3 = Arrays.asList(input3.split(","));

        assertThat(result).contains("b", "a", "c");
        assertThat(result).containsExactly("a", "b", "c");

        assertThat(result2).contains(" b", "a", " c");
        assertThat(result2).containsExactly("a", " b", " c");

        assertThat(result3).contains("", "b", "a");
        assertThat(result3).containsExactly("", "a", "b");
    }
}
