package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class InputValidationUnitTest {
    @Test
    void validateInputNames_유효한_입력을_구분자를_기준으로_잘라서_배열로_반환() {
        String testInput = "pobi,woni,jun,";

        String[] testResult = InputValidation.validateInputNames(testInput);

        assertThat(testResult).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void validateInputNames_6글자가_넘는_이름_입력_시_예외_발생() {
        String testInput = "pobj,longlongman,jun,";

        assertThatThrownBy(() -> InputValidation.validateInputNames(testInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateInputNames_중복된_이름_입력_시_예외_발생() {
        String testInput = "pobi,woni,pobi,";

        assertThatThrownBy(() -> InputValidation.validateInputNames(testInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateInputMoveCount_유효한_입력을_정수로_반환() {
        String testInput = "4242";

        int result = InputValidation.validateInputMoveCount(testInput);

        assertThat(result).isEqualTo(4242);
    }

    @Test
    void validateInputMoveCount_음수_입력_시_예외_발생() {
        String testInput = "-42";

        assertThatThrownBy(() -> InputValidation.validateInputMoveCount(testInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateInputMoveCount_숫자가_아닌_유효하지_않은_입력() {
        String testInput = "42ft";

        assertThatThrownBy(() -> InputValidation.validateInputMoveCount(testInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
