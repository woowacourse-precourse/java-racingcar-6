package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Input_car.*;

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
    void 자동차_이름_중복_입력_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car1,car2,car2", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 횟수_숫자_이외_글자_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("car1,car2,car3", "two"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값_확인_테스트() {
        run("car1,car2,car3", "3");
        assertThat(car_map.containsKey("car1")).isTrue();
        assertThat(car_map.containsKey("car2")).isTrue();
        assertThat(car_map.containsKey("car3")).isTrue();
        assertThat(excute_count.equals("3"));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
