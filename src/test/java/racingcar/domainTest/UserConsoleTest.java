package racingcar.domainTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import racingcar.Application;

public class UserConsoleTest extends NsTest {
    @Test
    void 이름입력_받기와_처리() {
        assertSimpleTest(() -> {
            run("pobi,minju", "1");

            assertThat(output()).contains("minju :");
            assertThat(output()).contains("pobi : ");
        });

    }

    @Test
    void 실시횟수_입력받고_저장() {
        assertSimpleTest(() -> {
            run("pobi,minju", "1");
            String result = output();
            int roundsCount = 0;
            roundsCount += (result.length() - result.replace("pobi", "").length()) / 4;

            assertThat(roundsCount < 3).isTrue();
            assertThat(roundsCount > 0).isTrue();
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
