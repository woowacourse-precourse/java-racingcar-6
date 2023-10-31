package racingGameTest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import static racingcar.controller.ExceptionController.carNameDuplicateException;
import static racingcar.controller.ExceptionController.carNameMaxLengthException;
import static racingcar.controller.ExceptionController.specialCharactersException;
import static racingcar.controller.ExceptionController.stringBlankException;
import static racingcar.controller.ExceptionController.tryCountLengthException;
import static racingcar.controller.ExceptionController.tryCountNotIntException;
import static racingcar.controller.ExceptionController.multiCommaException;

import static racingcar.controller.RacingGameController.commaBasedSplitCarName;
import static racingcar.controller.RacingGameController.makePersonalCarAndForwardStatus;

import java.util.HashMap;

public class FailCaseTest {

    @Test
    void duplicateCarName() {
        // given
        final String carName = "user1,user2,user3,user1";
        String[] carNameArr = commaBasedSplitCarName(carName);

        // when
        HashMap<String, String> carNameSave = makePersonalCarAndForwardStatus(carNameArr);

        // then
        assertThatThrownBy(() -> carNameDuplicateException(carNameSave, carNameArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @Test
    void inputTryCountInteger() {
        // given
        final String tryCount = "a";

        // when then
        assertThatThrownBy(() -> tryCountNotIntException(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @Test
    void inputStringBlank() {
        // given
        final String blankString = "user, ";

        // when then
        assertThatThrownBy(() -> stringBlankException(blankString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @Test
    void carNameExcludeSpecialChar() {
        // given
        final String specialChar = "user,user1,u@er";

        // when then
        assertThatThrownBy(() -> specialCharactersException(specialChar))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @Test
    void inputTryCountLength() {
        // given
        final String tryCount = "12";

        // when then
        assertThatThrownBy(() -> tryCountLengthException(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @Test
    void carNameMaxLength() {
        // given
        final String carName = "user,user1,user12";

        // when
        String[] carNameArr = carName.split(",");

        // then
        assertThatThrownBy(() -> carNameMaxLengthException(carNameArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @Test
    void multiComma() {
        // given
        final String carName = "user,user1,,user2";

        // when
        String[] carNameArr = carName.split(",");

        // then
        assertThatThrownBy(() -> multiCommaException(carNameArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("String index out of range: 5");
    }
}
