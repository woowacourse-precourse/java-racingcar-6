package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

class InputValidationTest {

    @EmptySource
    @ParameterizedTest
    @CsvSource(value = {"pobi#", "po bi"})
    void 숫자_알파벳_구분자_이외의_문자일_경우_예외_발생(String input) {
        assertThatThrownBy(() -> InputValidation.checkCharacter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력입니다.");
    }

    @Test
    void 자동차_이름이_중복일_경우_예외_발생() {
        List<String> carNames = new ArrayList<>();
        carNames.add("pobi");
        carNames.add("pobi");

        assertThatThrownBy(() -> InputValidation.checkOverlap(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름이 있습니다.");
    }

    @EmptySource
    @ParameterizedTest
    @CsvSource(value = {"123456"})
    void 자동차_이름_길이가_맞지_않을_경우_예외_발생(String input) {
        List<String> carNames = new ArrayList<>();
        carNames.add(input);

        assertThatThrownBy(() -> InputValidation.checkNameLength(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 길이가 맞지 않습니다.");
    }

    @EmptySource
    @ParameterizedTest
    @CsvSource(value = {"한글", "English"})
    void 입력받은_값이_숫자가_아닐_경우_예외_발생(String input) {
        assertThatThrownBy(() -> InputValidation.checkNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 값입니다.");
    }
}