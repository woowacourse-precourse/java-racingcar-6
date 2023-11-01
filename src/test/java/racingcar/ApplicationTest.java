package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingCarController;
import racingcar.model.Car;
import racingcar.service.RacingCarService;
import racingcar.util.Constants;

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
    void 이름_빈값에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "abd"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 횟수에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pob,jav", "abd"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
        //Car 초기화 + 아름 부여 + 우치 출력
    void car_init() {
        //given
        String name = "abc";
        //when
        Car car = new Car(name);
        //then
        assertThat(car.toString()).isEqualTo(name);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
        //Car 움직이기 + 위치 출력
    void init_game() {
        //given
        String input = "a,b,c";

        //when
        RacingCarService racingCarService = new RacingCarService();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
