package racingGameTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static racingcar.controller.ExceptionController.carNameDuplicateException;
import static racingcar.controller.ExceptionController.carNameMaxLengthException;
import static racingcar.controller.ExceptionController.specialCharactersException;
import static racingcar.controller.ExceptionController.stringBlankException;
import static racingcar.controller.ExceptionController.tryCountLengthException;
import static racingcar.controller.ExceptionController.tryCountNotIntException;
import static racingcar.controller.ExceptionController.multiCommaException;

import static racingcar.controller.RacingGameController.makePersonalCarAndForwardStatus;
import static racingcar.view.RacingGameView.commaBasedSplitCarName;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class FailCaseTest {

    @Test
    @DisplayName("중복된 자동차의 이름이 있는 경우")
    void duplicateCarName() {
        // given
        List<String> cars = commaBasedSplitCarName( "user1,user2,user3,user1");

        // when
        Map<String, Integer> carNameSave = makePersonalCarAndForwardStatus(cars);

        // then
        assertThatThrownBy(() -> carNameDuplicateException(carNameSave, cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수에 숫자 대신 문자를 넣었을 경우")
    void inputTryCountInteger() {
        // given
        final String tryCount = "a";

        // when then
        assertThatThrownBy(() -> tryCountNotIntException(tryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자열에 빈 칸이 있는 경우")
    void inputStringBlank() {
        // given
        final String blankString = "user, ";

        // when then
        assertThatThrownBy(() -> stringBlankException(blankString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("','를 제외한 특수 문자를 포함해 문자열을 입력한 경우")
    void carNameExcludeSpecialChar() {
        // given
        final String specialChar = "user,user1,u@er";

        // when then
        assertThatThrownBy(() -> specialCharactersException(specialChar))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("9 이상의 숫자를 입력한 경우")
    void inputTryCountLength() {
        // given
        final String tryCount = "12";

        // when then
        assertThatThrownBy(() -> tryCountLengthException(tryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름이 5글자를 초과한 경우")
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
    @DisplayName("연속적으로 ','가 들어간 경우")
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
