package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.enumType.message.ExceptionMessage.COMMA_MESSAGE;
import static racingcar.enumType.message.ExceptionMessage.DUPLICATE_MESSAGE;
import static racingcar.enumType.message.ExceptionMessage.EMPTY_MESSAGE;
import static racingcar.enumType.message.ExceptionMessage.LENGTH_MESSAGE;
import static racingcar.enumType.message.ExceptionMessage.NULL_MESSAGE;
import static racingcar.enumType.message.ExceptionMessage.SPACE_MESSAGE;
import static racingcar.enumType.message.ExceptionMessage.NUMERIC_FORMAT_MESSAGE;
import static racingcar.enumType.message.ExceptionMessage.RANGE_MESSAGE;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidationTest {

    @Test
    @DisplayName("각 자동차 이름 길이의 범위 테스트")
    void validateCarNameRangeTest() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        List<String> carNames = List.of("pobipobi", "woni", "jun");

        // then
        assertThatThrownBy(() -> inputValidation.validateCarNameRange(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_MESSAGE.getValue());
    }

    @Test
    @DisplayName("자동차 이름 중복 여부 테스트")
    void validateCarNameDuplicationTest() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        List<String> carNames = List.of("woni", "woni", "jun");

        // then
        assertThatThrownBy(() -> inputValidation.validateCarNameDuplication(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_MESSAGE.getValue());
    }

    @Test
    @DisplayName("자동차 이름에 공백이 있는지 테스트")
    void validateCarNameSpaceTest() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        List<String> carNamesLeftSpace = List.of("     fobi", "woni", "jun");
        List<String> carNamesMiddleSpace = List.of("fobi", "wo   ni", "jun");
        List<String> carNamesRightSpace = List.of("fobi", "woni", "jun    ");

        // then
        assertThatThrownBy(() -> inputValidation.validateCarNameSpace(carNamesLeftSpace))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(SPACE_MESSAGE.getValue());
        assertThatThrownBy(() -> inputValidation.validateCarNameSpace(carNamesMiddleSpace))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(SPACE_MESSAGE.getValue());
        assertThatThrownBy(() -> inputValidation.validateCarNameSpace(carNamesRightSpace))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(SPACE_MESSAGE.getValue());
    }

    @Test
    @DisplayName("각 자동차 이름이 빈 값인지 테스트")
    void validateCarNameEmptyTest() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        List<String> carNamesWithEmpty = List.of("fobi", "woni", "");

        // then
        assertThatThrownBy(() -> inputValidation.validateCarNameEmpty(carNamesWithEmpty))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY_MESSAGE.getValue());
    }

    @Test
    @DisplayName("입력값이 null인지 테스트")
    void validateInputNullTest() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        String input = null;

        // then
        assertThatThrownBy(() -> inputValidation.validateInputNull(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NULL_MESSAGE.getValue());
    }

    @Test
    @DisplayName("입력된 자동차 이름 들이 , 로 구분 되어 있는지 판단")
    void validateCommaSeparatedCarNamesTest() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        String carName = "pobiwonijun";

        // then
        assertThatThrownBy(() -> inputValidation.validateCommaSeparatedCarNames(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(COMMA_MESSAGE.getValue());
    }

    @Test
    @DisplayName("자동차 입력값에 대해 모든 검증을 하는 테스트")
    void validateCarNamesTest() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        String carNames = "pobi,woni,jun";

        // then
        assertThatCode(() -> inputValidation.validateCarNames(carNames))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력값이 숫자 포맷인지 검증을 하는 테스트")
    void validateInputNumericFormatTest() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        String input = "one";

        // then
        assertThatThrownBy(() -> inputValidation.validateInputNumericFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMERIC_FORMAT_MESSAGE.getValue());
    }

    @Test
    @DisplayName("입력값이 0이하인지 검증을 하는 테스트")
    void validateInputRangeTest() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        String input = "0";

        // then
        assertThatThrownBy(() -> inputValidation.validateInputRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RANGE_MESSAGE.getValue());
    }

    @Test
    @DisplayName("시도할 횟수 입력값이 빈값인지 검증 하는 테스트")
    void validateInputEmptyTest() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        String input = "";

        // then
        assertThatThrownBy(() -> inputValidation.validateInputEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY_MESSAGE.getValue());
    }

    @Test
    @DisplayName("시도할 횟수 입력에 대해 모든 검증을 하는 테스트")
    void validateAttemptInputTest() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        String input = "1";

        // then
        assertThatCode(() -> inputValidation.validateAttemptInput(input))
                .doesNotThrowAnyException();
    }
}