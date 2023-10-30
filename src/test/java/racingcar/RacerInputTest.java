package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacerInputTest {
    @Test
    void 입력_자릿수_예외테스트() {
        assertThatThrownBy(() -> {
            List<String> racerList = new ArrayList<>(Arrays.asList("Black", "White", "Greens"));
            InputNameCheck.nameCheck(racerList);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}
