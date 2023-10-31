package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class GameControllerTest extends NsTest {
    @Test
    void 공동_우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,  woni", "2");
                    assertThat(output()).contains("pobi : -", "woni : -", "pobi : --", "woni : --",
                            "최종 우승자 : pobi, woni");
                }, 4, 4, 4, 4
        );
    }

    public void runMain() {
        Application.main(new String[]{});
    }
}
