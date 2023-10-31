package racingGameTest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static racingcar.controller.RacingGameController.commaBasedSplitCarName;
import static racingcar.controller.RacingGameController.makePersonalCarAndForwardStatus;

import static racingcar.view.RacingGameView.stringTryCountToInteger;

import java.util.HashMap;

public class SuccessCaseTest {

    @Test
    void notDuplicatedCarName() {
        // given
        final String carName = "user1,user2,user3";
        String[] carNameArr = carName.split(",");

        // when
        HashMap<String, String> carNameSave = new HashMap<>();
        carNameSave.put("user1", "");
        carNameSave.put("user2", "");
        carNameSave.put("user3", "");

        // then
        assertThat(carNameSave).isEqualTo(makePersonalCarAndForwardStatus(carNameArr));
    }

    @Test
    void inputTryCountInteger() {
        // given
        final String tryCount = "5";
        final int compareInt = 5;

        // when
        int tryCountInteger = stringTryCountToInteger(tryCount);

        // then
        assertThat(compareInt).isEqualTo(tryCountInteger);
    }

    @Test
    void inputStringBlank() {
        // given
        final String carName = "user1,user2";
        String[] testCarNameArr = new String[]{"user1", "user2"};

        // when
        String[] carNameArr = commaBasedSplitCarName(carName);

        // then
        assertThat(testCarNameArr).isEqualTo(carNameArr);
    }

    @Test
    void carNameMaxLength() {
        // given
        final String carName = "user,user1,user2";
        String[] carNameArrTest = carName.split(",");

        // when
        String[] carNameArr = commaBasedSplitCarName(carName);

        // then
        assertThat(carNameArr).isEqualTo(carNameArr);
    }
}
