package racingGameTest;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.controller.RacingGameController.makePersonalCarAndForwardStatus;
import static racingcar.view.RacingGameView.stringTryCountToInteger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.view.RacingGameView;

public class SuccessCaseTest {

    @Test
    void notDuplicatedCarName() {
        // given
        final String carName = "user1,user2,user3";
        List<String> carNameArr = List.of(carName.split(","));

        // when
        Map<String, Integer> carNameSave = new HashMap<>();
        carNameSave.put("user1", 0);
        carNameSave.put("user2", 0);
        carNameSave.put("user3", 0);

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
        List<String> testCars = List.of("user1", "user2");

        // when
        List<String> cars = RacingGameView.commaBasedSplitCarName(carName);

        // then
        assertThat(testCars).isEqualTo(cars);
    }

    @Test
    void carNameMaxLength() {
        // given
        final String carName = "user,user1,user2";
        List<String> carNamesTest = List.of(carName.split(","));

        // when
        List<String> carNames = RacingGameView.commaBasedSplitCarName(carName);

        // then
        assertThat(carNames).isEqualTo(carNamesTest);
    }
}
