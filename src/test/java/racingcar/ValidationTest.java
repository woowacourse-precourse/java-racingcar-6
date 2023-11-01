package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.Validation;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static racingcar.constant.Constant.*;

class ValidationTest {
    @DisplayName("자동차명에 대한 통합 검증 테스트")
    @Test
    void validateCarNames() {
        //given
        String containSpace = "cat,do g,cow,eagle";
        String containBlankName = "cat,,dog,cow,eagle";
        String overLengthName = "cat,rabbit,dog,cow";
        String duplicatedName = "rat,dog,cow,dog,cat";
        //when
        //then
        assertThatThrownBy(() -> Validation.validateCarNames(containSpace))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_CONTAIN_WHITESPACE);
        assertThatThrownBy(() -> Validation.validateCarNames(containBlankName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_INVALID_CAR_NAME_LENGTH);
        assertThatThrownBy(() -> Validation.validateCarNames(overLengthName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_INVALID_CAR_NAME_LENGTH);
        assertThatThrownBy(() -> Validation.validateCarNames(duplicatedName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_DUPLICATE_CAR_NAME);
    }

    @DisplayName("자동차 이름에 공백이 포함되어 있을 경우 에러 반환")
    @Test
    void validateWhiteSpace() {
        String inputWithSpace = "cat, do g, eagle, cow";
        String[] carNames = inputWithSpace.split(",", -1);

        assertThatThrownBy(() -> Validation.validateWhiteSpace(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_CONTAIN_WHITESPACE);
    }

    @DisplayName("지정된 구분자가 아닐 경우 에러 반환")
    @Test
    void validateDelimiterType() {
        String input = "cat,dog.cow,eagle";
        String[] carNames = input.split(",", -1);

        assertThatThrownBy(() -> Validation.validateDelimiterType(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_DELIMITER_TYPE);
    }

    @DisplayName("자동차의 이름이 5자를 넘을 경우 에러 반환 테스트")
    @Test
    void validateNameLengthOver() {
        String input = "cat,dog,cow,turtle,human";
        String[] carNames = input.split(",", -1);

        assertThatThrownBy(() -> Validation.validateNameLength(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_INVALID_CAR_NAME_LENGTH);
    }

    @DisplayName("자동차의 이름 중 빈칸이 있다면 에러 반환 테스트")
    @Test
    void validateNameLengthLess() {
        String hasEmpty = "cat,,cow,turtle,cat";
        String[] carNames = hasEmpty.split(",", -1);

        assertThatThrownBy(() -> Validation.validateNameLength(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_INVALID_CAR_NAME_LENGTH);
    }

    @DisplayName("중복된 이름이 있다면 에러 반환")
    @Test
    void validateDuplicateName() {
        String input = "cat,dog,cow,eagle,cow,human";
        String[] carNames = input.split(",", -1);

        assertThatThrownBy(() -> Validation.validateDuplicateName(carNames.length, carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_DUPLICATE_CAR_NAME);
    }

    @DisplayName("게임 횟수에 대한 통합 검증 테스트")
    @Test
    public void validateGameRound() throws Exception {
        //given
        String validRound = "33";
        String containNotDigit = " 3";
        String containAlpha = "3a3";
        String blank = "";

        assertThatThrownBy(() -> Validation.validateGameRound(containNotDigit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_ROUND_TYPE);
        assertThatThrownBy(() -> Validation.validateGameRound(containAlpha))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_ROUND_TYPE);
        assertThatThrownBy(() -> Validation.validateBlankRound(blank))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_ROUND_LENGTH);
        assertThat(Validation.validateGameRound(validRound)).isEqualTo(33);
    }

    @DisplayName("횟수가 숫자가 아닐 경우 에러 반환")
    @Test
    void validateRoundType() {
        String input = "a2ajw";

        assertThatThrownBy(() -> Validation.validateRoundType(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_ROUND_TYPE);
    }

    @DisplayName("횟수를 입력하지 않은 경우 에러 반환")
    @Test
    void validateBlankRound() {
        String blank = "";

        assertThatThrownBy(() -> Validation.validateBlankRound(blank))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_ROUND_LENGTH);
    }
}