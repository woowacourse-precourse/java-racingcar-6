package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class RaceManagerTest extends NsTest {

    private static final String MESSAGE =
            "raceCarList=[RaceCar{name=pobi, position=RacePosition{currentPosition=%d}}, "
                    + "RaceCar{name=woni, position=RacePosition{currentPosition=%d}}]";

    @Test
    void 시도1번포비1워니0() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains(String.format(MESSAGE, 1, 0));
                },
                4, 3
        );
    }

    @Test
    void 시도3포비1워니2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains(String.format(MESSAGE, 1, 2));
                },
                4, 3, 2, 6, 2, 6
        );
    }

    @Test
    void 시도3포비2워니2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains(String.format(MESSAGE, 2, 2));
                },
                4, 4, 5, 5, 2, 2
        );
    }

    @Override
    public void runMain() {
        RaceManager raceManager = new RaceManager();
        raceManager.startRace();
        System.out.println("raceManager = " + raceManager);
    }
}