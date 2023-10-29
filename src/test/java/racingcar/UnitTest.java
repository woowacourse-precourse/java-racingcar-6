package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.util.InputUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UnitTest {
    @Test
    public void strToList(){
        String input = "a,b,c,d,";
        List<String> expected = List.of("a","b","c","d");

        List<String> actual = InputUtil.inputNames(input);

        assertThat(actual).isEqualTo(expected);
    }
}
