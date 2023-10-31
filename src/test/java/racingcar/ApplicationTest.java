package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : - ", "woni : ");
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
    void 입력받은_자동차_이름_구분_테스트() {
        String input = "pobi,woni,jun";
        assertThat(Application.getCarNamesFromInput(input)).isEqualTo(
                List.of("pobi", "woni", "jun"));
    }

    @Test
    void 이름의_길이_5자_초과_입력_테스트() {
        String input = "pobi, wonii, junnie";
        assertThatThrownBy(() -> Application.getCarNamesFromInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도할_횟수_입력_테스트(){
        String input = "5";
        assertThat(Integer.parseInt(input)).isEqualTo(5);
    }

    @Test
    void 무작위_값_이동_테스트(){
        Map<String, Integer> cars = new HashMap<>();
        cars.put("pobi", 0);
        cars.put("woni", 0);
        assertRandomNumberInRangeTest(
                () -> {
                    Application.race(cars);
                    assertThat(output()).contains("pobi : - ", "woni :");
                },
                MOVING_FORWARD, STOP
        );

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
