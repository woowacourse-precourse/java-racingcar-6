package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputValidationTest {

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
}