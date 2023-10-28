package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    @Test
    void 입력받은_이름을_쪼개기() {
        List<String> inputs = Arrays.asList("pobi,woni,jun", " ,  ",
                "hi", ",,,", ",a,", "  ");
        List<List<String>> results = Arrays.asList(Arrays.asList("pobi", "woni", "jun"),
                Arrays.asList(" ", "  "), Arrays.asList("hi"), Arrays.asList("", "", "", ""),
                Arrays.asList("", "a", ""), Arrays.asList("  "));

        for (int i = 0; i < inputs.size(); i++) {
            assertThat(new CarNames().splitNames(inputs.get(i))).isEqualTo(results.get(i));
        }
    }

    @Test
    void 이름이_공백으로만_이루어진_경우_예외처리() {
        List<String> inputs = Arrays.asList("", " ", "    ,  ", ",,,,");
        inputs.stream().forEach(input -> {
            assertThatThrownBy(() -> new CarNames().checkBlankInput(input))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 이름_길이가_5이하가_아닌_경우_예외처리() {
        List<String> inputs = Arrays.asList("12, 01-, 123210", "pobi,pororo,crong", "ham bur ger");
        inputs.stream().forEach(input -> {
            assertThatThrownBy(() -> new CarNames().checkNameLength(input))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 같은_이름이_들어온_경우_예외처리() {
        List<String> inputs = Arrays.asList("a,a,a", "pobi,crong,pobi", "*,!,!");
        inputs.stream().forEach(input -> {
            assertThatThrownBy(() -> new CarNames().checkSameNames(input))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }
}
