package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class ActionTest extends NsTest {

    @BeforeEach
    void setup() {

    }
    @Test
    void 전진및정지확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("july,april,march","1");
                    assertThat(output()).contains("july : -", "april : ", "march : -", "최종 우승자 : july, march");
                },
                4,3,7
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}