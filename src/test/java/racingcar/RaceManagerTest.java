package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class RaceManagerTest extends NsTest {

    private static final String MESSAGE_FOR_POBI = "pobi : %s";
    private static final String MESSAGE_FOR_WONI = "woni : %s";

    private String to(int i) {
        return "-".repeat(i);
    }

    @Test
    void 시도1번포비1워니0() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains(
                            String.format(MESSAGE_FOR_POBI, to(1)), String.format(MESSAGE_FOR_WONI, to(0))
                    );
                },
                4, 3, 5, 0, 5, 0
        );
    }

    @Test
    void 시도3포비1워니2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains(
                            String.format(MESSAGE_FOR_POBI, to(1)), String.format(MESSAGE_FOR_WONI, to(2))
                    );
                },
                4, 3, 2, 6, 2, 6
        );
    }

    @Test
    void 시도3포비2워니2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains(
                            String.format(MESSAGE_FOR_POBI, to(2)), String.format(MESSAGE_FOR_WONI, to(2))
                    );
                },
                4, 4, 5, 5, 2, 2
        );
    }

    @Override
    public void runMain() {
        RaceManager raceManager = new RaceManager();
        raceManager.startRace();
    }
}