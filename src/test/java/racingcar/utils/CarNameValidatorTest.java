package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameValidatorTest {

    @Test
    @DisplayName("자동차의 이름이 두 개 미만일 경우 예외를 발생시킨다.")
    void throwExceptionCarNamesLessThan2() {
        //given
        String carNames = "miro";
        //when //then

        assertThatThrownBy(() -> CarNameValidator.validateMultipleCarName(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차는 두 대 이상 입력해야 합니다.");
    }

    @Test
    @DisplayName("자동차의 이름이 두 개 이상일 경우 예외를 발생시키지 않는다.")
    void nonThrowExceptionCarNameGreaterThanEquals2() {
        //given
        String carNames = "miro,romi";
        //when //then

        assertThatCode(() -> CarNameValidator.validateMultipleCarName(carNames))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차의 이름이 공백으로만 이루어진 빈 문자열일 경우 예외를 발생시킨다.")
    void throwExceptionCarNameIsBlank() {
        //given
        String carName = "     ";
        //when //then
        assertThatThrownBy(() -> CarNameValidator.validateCarName(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름이 영어를 제외한 문자가 포함되어 있는 경우 예외를 발생시킨다.")
    void throwExceptionCarNameContainExcludedAlphabet() {
        //given
        String carName = "123";
        //when //then
        assertThatThrownBy(() -> CarNameValidator.validateCarName(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름의 길이가 5초과인 경우 예외를 발생시킨다.")
    void throwExceptionCarNameLengthGreaterThan5() {
        //given
        String carName = "miroro";
        //when //then
        assertThatCode(() -> CarNameValidator.validateCarName(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름에 공백이 포함되어 있는 경우 예외를 발생시킨다.")
    void throwExceptionCarNameContainBlank() {
        //given
        String carName = "mi ro";
        //when //then
        assertThatThrownBy(() -> CarNameValidator.validateCarName(carName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름이 5자 이하의 영문자로만 구성되어 있는 경우 예외를 발생시키지 않는다.")
    void nonThrowExceptionCarNameContainOnlyAlphabetAndLengthLessThanEquals5() {
        //given
        String carName = "miro";
        //when //then
        assertThatCode(() -> CarNameValidator.validateCarName(carName))
            .doesNotThrowAnyException();
    }
}