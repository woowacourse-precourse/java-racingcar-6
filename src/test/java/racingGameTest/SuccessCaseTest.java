package racingGameTest;

import static racingcar.controller.RacingGameController.makePersonalCarAndForwardStatus;
import static racingcar.controller.RacingGameController.mostMoveForwardCar;
import static racingcar.controller.RacingGameController.moveCondition;
import static racingcar.view.RacingGameView.commaBasedSplitCarName;
import static racingcar.view.RacingGameView.stringTryCountToInteger;
import static racingcar.view.RacingGameView.winner;

import racingcar.Constant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("정상적인 입력 값을 넣었을 시 성공 케이스")
public class SuccessCaseTest {

    @Test
    void notDuplicatedCarName() {
        // given
        String carName = "user1,user2,user3";
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
        String tryCount = "5";
        int compareInt = 5;

        // when
        int tryCountInteger = stringTryCountToInteger(tryCount);

        // then
        assertThat(compareInt).isEqualTo(tryCountInteger);
    }

    @Test
    void inputStringBlank() {
        // given
        String carName = "user1,user2";
        List<String> testCars = List.of("user1", "user2");

        // when
        List<String> cars = commaBasedSplitCarName(carName);

        // then
        assertThat(testCars).isEqualTo(cars);
    }

    @Test
    void carNameMaxLength() {
        // given
        String carName = "user,user1,user2";
        List<String> carNamesTest = List.of(carName.split(","));

        // when
        List<String> carNames = commaBasedSplitCarName(carName);

        // then
        assertThat(carNames).isEqualTo(carNamesTest);
    }

    @Test
    void forwardOrNot() {
        // given
        String carName = "jung";
        int firstCarPosition = 0;
        int forwardCondition = 4;

        // when
        Map<String, Integer> carForwardTest = new HashMap<>();
        carForwardTest.put(carName, firstCarPosition);
        moveCondition(carForwardTest, carName, forwardCondition);

        firstCarPosition = firstCarPosition + 1;

        // then
        assertThat(carForwardTest.get(carName)).isEqualTo(firstCarPosition);

        // given
        int secondPosition = firstCarPosition;
        int stopCondition = 3;

        // when
        Map<String, Integer> carNotForwardTest = carForwardTest;
        moveCondition(carNotForwardTest, carName, stopCondition);

        // then
        assertThat(carNotForwardTest.get(carName)).isEqualTo(secondPosition);
    }

    @Test
    void winnerMessage() {
        // given
        String winnerCar = "jeong";
        String loserCar = "jung";

        int winnerPosition = 2;
        int loserPosition = 1;

        Map<String, Integer> carMoveStatus = new HashMap<>();

        carMoveStatus.put(winnerCar, winnerPosition);
        carMoveStatus.put(loserCar, loserPosition);

        // when
        List<String> winnerStatus = mostMoveForwardCar(carMoveStatus);
        String winnerTest = winner(winnerStatus);

        // then
        assertThat(winnerTest).isEqualTo(Constant.WINNER_LIST + winnerCar);
    }

    @Test
    void winnersMessage() {
        // given
        String firstWinner = "jung";
        String secondWinner = "jeong";

        int winnerPosition = 2;

        Map<String, Integer> carMoveStatus = new HashMap<>();

        carMoveStatus.put(firstWinner, winnerPosition);
        carMoveStatus.put(secondWinner, winnerPosition);

        // when
        List<String> winnersStatus = mostMoveForwardCar(carMoveStatus);
        String winnersTest = winner(winnersStatus);

        String winners = Constant.WINNER_LIST + firstWinner + Constant.COMMA_SPACE + secondWinner;

        // then
        assertThat(winnersTest).isEqualTo(winners);
    }
}
