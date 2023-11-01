package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

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

    @Test
    void 자동차_생성() {
        String[] input = {"pobi", "woni", "jun"};
        LinkedHashMap<String, String> ex = new LinkedHashMap<>();
        ex.put("pobi", "");
        ex.put("woni", "");
        ex.put("jun", "");
        LinkedHashMap<String, String> result = Application.generateCar(input);

        assertThat(result).isEqualTo(ex);
    }

    @Test
    void 전진_거리() {
        List<String> input = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));
        LinkedHashMap<String, String> ex = new LinkedHashMap<>();
        ex.put("pobi", "");
        ex.put("woni", "");
        ex.put("jun", "");
        LinkedHashMap<String, String> result = Application.goStop(ex, input);

        assertThat(result.containsKey("pobi"));
        assertThat(result.containsKey("woni"));
        assertThat(result.containsKey("jun"));
    }

    @Test
    void 최대_전진_자동차() {
        List<String> input = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));
        LinkedHashMap<String, String> ex = new LinkedHashMap<>();
        ex.put("pobi", "----");
        ex.put("woni", "--");
        ex.put("jun", "----");
        List<String> result = Application.findMaxValueCar(ex, input);

        assertThat(result).contains("pobi", "jun");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
