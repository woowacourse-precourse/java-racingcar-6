package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class RacingGameTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 게임_출력_테스트() {
        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "2");
                    assertThat(output()).contains(
                            "실행 결과",
                            "pobi : -",
                            "woni : ",
                            "jun : ",
                            "pobi : --",
                            "woni : ",
                            "jun : ",
                            "최종 우승자 : pobi"
                    );
                },
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
