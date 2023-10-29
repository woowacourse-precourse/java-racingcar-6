package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckerTest {
    @Test
    void 이름이_5자_초과일_경우_false_리턴() {
        List<String> correctNames = Arrays.asList("name1", "name");
        List<String> incorrectNames = Arrays.asList("incorrect", "name2");

        assertThat(Checker.isNameAllCorrect(correctNames)).isTrue();
        assertThat(Checker.isNameAllCorrect(incorrectNames)).isFalse();
    }
}
