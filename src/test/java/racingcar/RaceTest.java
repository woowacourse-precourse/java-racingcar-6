package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.domain.Car;

public class RaceTest extends NsTest{
    @Test
    void 사용자_입력으로_자동차_생성() {
        assertSimpleTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("pobi","woni");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
