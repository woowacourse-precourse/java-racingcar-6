package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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

    @Test
    @DisplayName("동일한 차의 이름이 중복으로 존재할 경우 예외를 발생시킨다.")
    void throwExceptionDuplicateCarNameExist() {
        //given
        List<String> carNames = List.of("miro", "miro1", "miro");
        //when //then
        assertThatThrownBy(() -> CarNameValidator.validateDuplicateCarName(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("같은 자동차 이름이 중복으로 들어올 수 없습니다.");
    }

    @Test
    @DisplayName("중복된 차의 이름이 존재하지 않을 경우 예외를 발생시키지 않는다.")
    void nonThrowExceptionDuplicateCarNameNotExist() {
        //given
        List<String> carNames = List.of("miro", "romi", "rimo");
        //when //then
        assertThatCode(() -> CarNameValidator.validateDuplicateCarName(carNames))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차의 이름이 10개보다 많을경우 예외를 발생시킨다.")
    void throwExceptionCarNameCountGreater10() {
        //given
        List<String> carNames = List.of("a","b","c","d","e","f","g","h","i","j", "k");
        //when //then
        assertThatThrownBy(() -> CarNameValidator.validateMaxCountCarName(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차는 최대 10대까지 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("자동차의 이름이 10개보다 많을경우 예외를 발생시킨다.")
    void nonThrowExceptionCarNameCountLessThanEqual10() {
        //given
        List<String> carNames = List.of("a","b","c","d","e","f","g","h","i","j");
        //when //then
        assertThatCode(() -> CarNameValidator.validateMaxCountCarName(carNames))
            .doesNotThrowAnyException();
    }
}