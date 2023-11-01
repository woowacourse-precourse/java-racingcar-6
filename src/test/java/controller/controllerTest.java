package controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.controller.RaceController;
import racingcar.dto.Players;


class controllerTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private RaceController raceController;

    @BeforeEach
    void setUp() {
        raceController = new RaceController();
    }

    @ParameterizedTest
    @CsvSource({"pobi,woni,jun, 3, 최종 우승자 : woni", "alice,bob,charlie, 3, 최종 우승자 : alice"})
    public void moreThan100Attempt(String player1, String player2, String player3, int attemptCount, String expected) {
        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    run("pobi,woni,jun", "3");
                    // then
                    AssertionsForClassTypes.assertThat(output()).contains("");
                },
                // given
                8, 1, 1, 8, 1, 1, 8, 1, 1
        );

        raceController.raceSimulate(new Players(Arrays.asList(player1, player2, player3)), attemptCount);

    }

    @Override
    protected void runMain() {

    }
}
