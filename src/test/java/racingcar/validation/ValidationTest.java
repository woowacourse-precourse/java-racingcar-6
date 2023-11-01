package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    @Test
    void 다섯_글자를_초과한_입력() {
        String input = "a,bb,ccc,dddd,eeeee,ffffff";
        List<String> carNames = List.of(input.split(","));

        assertThatThrownBy(() -> Validation.areLessThenSixLetters(carNames));
    }

    @Test
    void 중복된_이름을_가지는_입력() {
        String input = "a,b,c,a";
        List<String> carNames = List.of(input.split(","));

        assertThatThrownBy(() -> Validation.isDuplicateCarName(carNames));
    }

}
