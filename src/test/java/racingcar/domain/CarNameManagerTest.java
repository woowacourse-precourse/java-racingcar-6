package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.BlankValidator;

public class CarNameManagerTest {
    BlankValidator blankValidator = new BlankValidator();
    CarNameManager carNameManager = new CarNameManager(blankValidator);

    @DisplayName("자동차이동름입력 - 정상입력")
    @Test
    void checkNormalCarNmaeInput() {
        String carName = "hong,kim,jun";
        List<String> name = carNameManager.processCarNames(carName);
        assertDoesNotThrow(() -> carNameManager.validateCarNames(name));
    }

    @DisplayName("자동차이동름입력 - 공백포함 5자입력시 정상입력처리")
    @Test
    void checklCarNmaeWithSpaces5() {
        String carName = "kim,12 45,jun";
        List<String> name = carNameManager.processCarNames(carName);
        assertDoesNotThrow(() -> carNameManager.validateCarNames(name));
    }

    @DisplayName("자동차이동름입력 - 양옆 공백 입력시 정상입력처리")
    @Test
    void checklCarNmaeWithSpacesOnBothSides() {
        String carName = "kim,   1245     ,jun";
        List<String> name = carNameManager.processCarNames(carName);
        Assertions.assertThat(name).contains("1245");
    }

    @DisplayName("자동차이동름입력 - 공백포함 5자 초과입력시 예외발생")
    @Test
    void checklCarNmaeWithSpacesOver5() {
        String carName = "kim,12  45,jun";
        List<String> carNameList = carNameManager.processCarNames(carName);
        assertThrows(IllegalArgumentException.class, () -> carNameManager.validateCarNames(carNameList));
    }

    @DisplayName("자동차이동름입력 - 5자 초과입력시 예외발생")
    @Test
    void checklCarNmaeInputOverSize() {
        String carName = "hosdfsdng,kim,jun";
        List<String> carNameList = carNameManager.processCarNames(carName);
        assertThrows(IllegalArgumentException.class, () -> carNameManager.validateCarNames(carNameList));
    }

    @DisplayName("자동차이동름입력 - 중복된 이름입력시 예외발생")
    @Test
    void checklCarNmaeInputDuplicate() {
        String carName = "kim,kim,jun";
        List<String> carNameList = carNameManager.processCarNames(carName);
        assertThrows(IllegalArgumentException.class, () -> carNameManager.validateCarNames(carNameList));
    }

    @DisplayName("자동차이동름입력 - ,로 시작시 예외발생")
    @Test
    void checklCarNmaeStartsWithComma() {
        String carName = ",kim,jun";
        assertThrows(IllegalArgumentException.class, () -> carNameManager.processCarNames(carName));
    }

    @DisplayName("자동차이동름입력 - ,로 끝날시 예외발생")
    @Test
    void checklCarNmaeEndWithComma() {
        String carName = "kim,jun,";
        assertThrows(IllegalArgumentException.class, () -> carNameManager.processCarNames(carName));
    }

    @DisplayName("자동차이동름입력 - ,로 끝날시 예외발생")
    @Test
    void checklCarNmaeDoubleComma() {
        String carName = "kim,  ,jun,";
        assertThrows(IllegalArgumentException.class, () -> carNameManager.processCarNames(carName));
    }

}
