package racingGameTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import static racingcar.controller.ExceptionController.carNameDuplicateException;
import static racingcar.controller.ExceptionController.carNameMaxLengthException;
import static racingcar.controller.ExceptionController.specialCharactersException;
import static racingcar.controller.ExceptionController.stringBlankException;
import static racingcar.controller.ExceptionController.tryCountLengthException;
import static racingcar.controller.ExceptionController.tryCountNotIntException;
import static racingcar.controller.ExceptionController.multiCommaException;

import static racingcar.controller.RacingGameController.makePersonalCarAndForwardStatus;

import racingcar.view.RacingGameView;

public class FailCaseTest {

    @Test
    void duplicateCarName() {
        // given
        List<String> cars = RacingGameView.commaBasedSplitCarName( "user1,user2,user3,user1");

        // when
        Map<String, Integer> carNameSave = makePersonalCarAndForwardStatus(cars);

        // then
        assertThatThrownBy(() -> carNameDuplicateException(carNameSave, cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputTryCountInteger() {
        // given
        final String tryCount = "a";

        // when then
        assertThatThrownBy(() -> tryCountNotIntException(tryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputStringBlank() {
        // given
        final String blankString = "user, ";

        // when then
        assertThatThrownBy(() -> stringBlankException(blankString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void carNameExcludeSpecialChar() {
        // given
        final String specialChar = "user,user1,u@er";

        // when then
        assertThatThrownBy(() -> specialCharactersException(specialChar))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputTryCountLength() {
        // given
        final String tryCount = "12";

        // when then
        assertThatThrownBy(() -> tryCountLengthException(tryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void carNameMaxLength() {
        // given
        final String carName = "user,user1,user12";

        // when
        List<String> carNameArr = Arrays.asList(carName.split(","));

        // then
        assertThatThrownBy(() -> carNameMaxLengthException(carNameArr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void multiComma() {
        // given
        String carName = "user,user1,,user2";

        // when
        List<String> carNames = Arrays.asList(carName.split(","));

        // then
        assertThatThrownBy(() -> multiCommaException(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
