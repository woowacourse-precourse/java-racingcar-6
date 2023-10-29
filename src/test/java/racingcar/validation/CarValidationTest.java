package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.MessageConst.COMMA_MESSAGE;
import static racingcar.constant.MessageConst.DUPLICATE_MESSAGE;
import static racingcar.constant.MessageConst.EMPTY_MESSAGE;
import static racingcar.constant.MessageConst.LENGTH_MESSAGE;
import static racingcar.constant.MessageConst.NULL_MESSAGE;
import static racingcar.constant.MessageConst.SPACE_MESSAGE;

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

    @Test
    @DisplayName("자동차 이름에 공백이 있는지 테스트")
    void validateCarNameSpaceTest() {
        // given
        CarValidation carValidation = new CarValidation();

        // when
        List<String> carNamesLeftSpace = List.of("     fobi", "woni", "jun");
        List<String> carNamesMiddleSpace = List.of("fobi", "wo   ni", "jun");
        List<String> carNamesRightSpace = List.of("fobi", "woni", "jun    ");

        // then
        assertThatThrownBy(() -> carValidation.validateCarNameSpace(carNamesLeftSpace))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(SPACE_MESSAGE);
        assertThatThrownBy(() -> carValidation.validateCarNameSpace(carNamesMiddleSpace))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(SPACE_MESSAGE);
        assertThatThrownBy(() -> carValidation.validateCarNameSpace(carNamesRightSpace))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(SPACE_MESSAGE);
    }

    @Test
    @DisplayName("각 자동차 이름이 빈 값인지 테스트")
    void validateCarNameEmptyTest() {
        // given
        CarValidation carValidation = new CarValidation();

        // when
        List<String> carNamesWithEmpty = List.of("fobi", "woni", "");

        // then
        assertThatThrownBy(() -> carValidation.validateCarNameEmpty(carNamesWithEmpty))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY_MESSAGE);
    }

    @Test
    @DisplayName("입력값이 null인지 테스트")
    void validateInputNullTest() {
        // given
        CarValidation carValidation = new CarValidation();

        // when
        String input = null;

        // then
        assertThatThrownBy(() -> carValidation.validateInputNull(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NULL_MESSAGE);
    }

    @Test
    @DisplayName("입력된 자동차 이름 들이 , 로 구분 되어 있는지 판단")
    void validateCommaSeparatedCarNamesTest() {
        // given
        CarValidation carValidation = new CarValidation();

        // when
        String carName = "pobiwonijun";

        // then
        assertThatThrownBy(() -> carValidation.validateCommaSeparatedCarNames(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(COMMA_MESSAGE);
    }

    @Test
    @DisplayName("자동차 입력값에 대해 모든 검증을 하는 테스트")
    void validateCarNamesTest() {
        // given
        CarValidation carValidation = new CarValidation();

        // when
        String carNames = "pobi,woni,jun";

        // then
        assertThatCode(() -> carValidation.validateCarNames(carNames))
                .doesNotThrowAnyException();
    }
}