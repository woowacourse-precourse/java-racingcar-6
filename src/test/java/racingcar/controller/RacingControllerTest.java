package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.testhelpers.FixedNumberGenerator;
import racingcar.util.RacingNumberGenerator;

public class RacingControllerTest extends NsTest {

    private RacingController controller;

    @BeforeEach
    public void setup() {
        controller = new RacingController(new RacingNumberGenerator());
    }

    @Override
    protected void runMain() {
        controller.raceStart();
    }

    @DisplayName("다중 자동차 경주 테스트")
    @Test
    void testRaceWithMultipleCars() {
        controller = new RacingController(new FixedNumberGenerator(4));

        run("pobi,woni,jun", "3");

        assertThat(output()).contains(
                "pobi : ---",
                "woni : ---",
                "jun : ---"
        );
    }

    @DisplayName("자동차 움직임 없는 경우 테스트")
    @Test
    void testRaceWithCarNotMoving() {
        controller = new RacingController(new FixedNumberGenerator(3));

        run("pobi,woni", "4");

        assertThat(output()).contains(
                "pobi : ",
                "woni : "
        );
    }

}
