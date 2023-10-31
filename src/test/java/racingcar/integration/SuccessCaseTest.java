package racingcar.integration;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.integration.config.IntegrationTest;

class SuccessCaseTest extends IntegrationTest {

    @DisplayName("복수 우승자가 나오는 경우, 성공적으로 최종 우승자를 출력한다.")
    @Test
    void success_PluralWinner() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "5");
                    assertThat(output()).contains(
                            "pobi : -\nwoni : \njun : -",
                            "pobi : --\nwoni : -\njun : --",
                            "pobi : ---\nwoni : --\njun : ---",
                            "pobi : ----\nwoni : ---\njun : ----",
                            "pobi : -----\nwoni : ----\njun : -----",
                            "최종 우승자 : pobi,jun");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @DisplayName("우승자가 한 명 나오는 경우, 성공적으로 최종 우승자를 출력한다.")
    @Test
    void success_OneWinner() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "5");
                    assertThat(output()).contains(
                            "pobi : -\nwoni : \njun : ",
                            "pobi : --\nwoni : -\njun : ",
                            "pobi : ---\nwoni : --\njun : ",
                            "pobi : ----\nwoni : ---\njun : -",
                            "pobi : -----\nwoni : ----\njun : --",
                            "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, STOP,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }
}
