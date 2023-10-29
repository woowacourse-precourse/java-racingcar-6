package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
    void move_자동차_이동() {
        String[] carNames = new String[]{"andy", "cindy", "suzy"};
        String[] result = new String[]{"" ,"--", "--"};

        Map<String, String> forwardMap = new HashMap<>();
        for (int i = 0; i < carNames.length; i++) {
            forwardMap.put(carNames[i], "");
        }

        int move = 3;
        List<Integer>[] moveList = new List[]{
                Arrays.asList(1, 4, 7),
                Arrays.asList(1, 2, 8),
                Arrays.asList(1, 4, 2)};
        for (int i = 0; i < move; i++) {
            List<Integer> moves = moveList[i];
            for (int j = 0; j < moveList[i].size(); j++) {
                if (moves.get(j) >= 4) {
                    forwardMap.put(carNames[j], forwardMap.get(carNames[j]) + "-");
                }
            }
        }

        for (int i = 0; i < carNames.length; i++) {
            assertEquals(result[i], forwardMap.get(carNames[i]));
        }
    }

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
