package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    @Test
    void 다섯_글자를_초과한_입력_테스트() {
        String input = "a,bb,ccc,dddd,eeeee,ffffff";
        List<String> carNames = List.of(input.split(","));

        assertThatThrownBy(() -> Validation.areLessThenSixLetters(carNames));
    }

}
