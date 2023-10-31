package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void testFinalWinnerWithFixedNumberGenerator() {
        controller = new RacingController(new FixedNumberGenerator(4));
        run("pobi,woni", "1");
        assertThat(output()).contains("최종 우승자 : pobi");
    }

    @Test
    void testFinalWinnerWithFixedNumberGenerator2() {
        controller = new RacingController(new FixedNumberGenerator(0));
        run("pobi,woni", "1");
        assertThat(output()).contains("최종 우승자 : pobi, woni");
    }

    @Test
    void testInvalidCarNames() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> run("pobi,,woni", "5"));
        assertTrue(exception.getMessage().contains("잘못된 자동차 이름 입력 형식입니다."));
    }

    @Test
    void testInvalidAttemptCount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> run("pobi,woni", "invalid"));
        assertTrue(exception.getMessage().contains("자연수를 입력해주세요"));
    }


}
