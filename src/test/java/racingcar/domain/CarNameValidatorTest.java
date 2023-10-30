package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.BlankValidator;

public class CarNameValidatorTest {
    BlankValidator blankValidator = new BlankValidator();
    CarNameValidator carNameValidator = new CarNameValidator(blankValidator);

    @DisplayName("자동차이동름입력 - 정상입력")
    @Test
    void checkNormalCarNmaeInput() {
        String carName = "hong,kim,jun";
        assertDoesNotThrow(() -> carNameValidator.processCarNames(carName));
    }

    @DisplayName("자동차이동름입력 - 공백포함 5자입력시 정상입력처리")
    @Test
    void checklCarNmaeWithSpaces5() {
        String carName = "kim,12 45,jun";
        assertDoesNotThrow(() -> carNameValidator.processCarNames(carName));
    }

    @DisplayName("자동차이동름입력 - 양옆 공백 입력시 정상입력처리")
    @Test
    void checklCarNmaeWithSpacesOnBothSides() {
        String carName = "kim,   1245     ,jun";
        List<String> name = carNameValidator.processCarNames(carName);
        Assertions.assertThat(name).contains("1245");
    }

    @DisplayName("자동차이동름입력 - 공백포함 5자 초과입력시 예외발생")
    @Test
    void checklCarNmaeWithSpacesOver5() {
        String carName = "kim,12  45,jun";
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.processCarNames(carName));
    }

    @DisplayName("자동차이동름입력 - 5자 초과입력시 예외발생")
    @Test
    void checklCarNmaeInputOverSize() {
        String carName = "hosdfsdng,kim,jun";
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.processCarNames(carName));
    }

    @DisplayName("자동차이동름입력 - 중복된 이름입력시 예외발생")
    @Test
    void checklCarNmaeInputDuplicate() {
        String carName = "kim,kim,jun";
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.processCarNames(carName));
    }

    @DisplayName("자동차이동름입력 - ,로 시작시 예외발생")
    @Test
    void checklCarNmaeStartsWithComma() {
        String carName = ",kim,jun";
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.processCarNames(carName));
    }

    @DisplayName("자동차이동름입력 - ,로 끝날시 예외발생")
    @Test
    void checklCarNmaeEndWithComma() {
        String carName = "kim,jun,";
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.processCarNames(carName));
    }

    @DisplayName("자동차이동름입력 - ,로 끝날시 예외발생")
    @Test
    void checklCarNmaeDoubleComma() {
        String carName = "kim,  ,jun,";
        assertThrows(IllegalArgumentException.class, () -> carNameValidator.processCarNames(carName));
    }

}
