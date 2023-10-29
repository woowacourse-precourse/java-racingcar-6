package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void getCars_자동차이름_저장() {
        String carNames = "andy,cindy,suzy";
        Map<String, String> forwardMap = new HashMap<>();
        for (String car : carNames.split(",")) {
            forwardMap.put(car.trim(), "");
        }

        assertEquals(forwardMap.size(), 3);
        for (String key: forwardMap.keySet()) {
            assertEquals(forwardMap.get(key), "");
        }
    }

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
