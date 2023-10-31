package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static racingcar.util.constant.GameRule.END_INCLUSIVE;
import static racingcar.util.constant.GameRule.MOVING_FORWARD_CONDITION;
import static racingcar.util.constant.GameRule.START_INCLUSIVE;

import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    private final RacingGame racingGame = new RacingGame();

    @DisplayName("자동차(플레이어)가 MOVING_FORWARD_CONDITION에 설정된 이상의 값을 부여 받으면 전진한다.")
    @Test
    void startMethodMovingForwardTest() {
        //given
        HashMap<String, Integer> players = new HashMap<>();
        players.put("pobi", 0);

        //when, then
        assertRandomNumberInRangeTest(
                () -> {
                    racingGame.start(players);
                    Assertions.assertEquals(1,players.get("pobi"));
                },
                MOVING_FORWARD_CONDITION.getValue(), // 4
                END_INCLUSIVE.getValue() // 9
        );
    }

    @DisplayName("자동차(플레이어)가 MOVING_FORWARD_CONDITION에 설정된 미만의 값을 부여 받으면 정지한다.")
    @Test
    void startMethodMovingStopTest() {
        //given
        HashMap<String, Integer> players = new HashMap<>();
        players.put("pobi", 0);

        //when, then
        assertRandomNumberInRangeTest(
                () -> {
                    racingGame.start(players);
                    Assertions.assertEquals(0,players.get("pobi"));
                },
                START_INCLUSIVE.getValue(), // 0
                MOVING_FORWARD_CONDITION.getValue() - 1 // 4
        );
    }
}