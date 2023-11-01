package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThat;
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
        String validInput = "a,b,c,d";
        List<String> carNames = List.of(input.split(","));
        List<String> validCarNames = List.of(validInput.split(","));

        assertThatThrownBy(() -> Validation.containDuplicateCarName(carNames));
        assertThat(Validation.containDuplicateCarName(validCarNames)).isEqualTo(false);
    }

    @Test
    void 시도_회수_입력_범위() {
        Integer inputZero = 0;
        Integer inputNegativeSmall = -1;
        Integer inputPositiveSmall = 1;
        Integer inputNegativeLarge = Integer.MIN_VALUE;
        Integer inputPositiveLarge = Integer.MAX_VALUE;

        assertThatThrownBy(() -> Validation.isValidRange(inputZero));
        assertThatThrownBy(() -> Validation.isValidRange(inputNegativeSmall));
        assertThatThrownBy(() -> Validation.isValidRange(inputNegativeLarge));
        assertThat(true).isEqualTo(Validation.isValidRange(inputPositiveSmall));
        assertThat(true).isEqualTo(Validation.isValidRange(inputPositiveLarge));
    }

}
