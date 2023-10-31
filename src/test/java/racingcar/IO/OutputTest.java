package racingcar.IO;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class OutputTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 단독우승자_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    // given
                    run("pobi,woni", "1");
                    // when // then
                    assertThat(output()).contains("최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 공동우승자_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    // given
                    run("pobi,woni", "1");
                    // when // then
                    assertThat(output()).contains("최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}