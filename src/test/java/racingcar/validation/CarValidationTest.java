package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.MessageConst.DUPLICATE_MESSAGE;
import static racingcar.constant.MessageConst.LENGTH_MESSAGE;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarValidationTest {

    @Test
    @DisplayName("각 자동차 이름 길이의 범위 테스트")
    void validateCarNameRangeTest() {
        // given
        CarValidation carValidation = new CarValidation();

        // when
        List<String> carNames = List.of("pobipobi", "woni", "jun");

        // then
        assertThatThrownBy(() -> carValidation.validateCarNameRange(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_MESSAGE);
    }

    @Test
    @DisplayName("자동차 이름 중복 여부 테스트")
    void validateCarNameDuplicationTest() {
        // given
        CarValidation carValidation = new CarValidation();

        // when
        List<String> carNames = List.of("woni", "woni", "jun");

        // then
        assertThatThrownBy(() -> carValidation.validateCarNameDuplication(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_MESSAGE);
    }
}