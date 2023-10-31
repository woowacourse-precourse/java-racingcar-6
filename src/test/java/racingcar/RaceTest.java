package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.domain.Car;

public class RaceTest extends NsTest{
    private static final int MOVE_FORWARD = 4;
    @Test
    void 사용자_입력으로_자동차_생성() {
        assertSimpleTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("pobi","woni");
        });
    }

    @Test
    void 공동_우승_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVE_FORWARD,MOVE_FORWARD
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
