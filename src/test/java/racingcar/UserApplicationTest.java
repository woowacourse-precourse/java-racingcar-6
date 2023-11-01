package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.Race;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;


    @Test
    void 레이스_실행() {
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"));
        Race race = new Race(cars, 5);
        race.executeRace();
        assertThat(race.getWinners()).isNotEmpty();
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
    void 모두_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "10");
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni");
                },
                STOP, STOP, STOP, STOP, STOP, STOP, STOP, STOP, STOP
        );
    }

    @Test
    void 모두_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "10");
                    assertThat(output()).contains("pobi : ----------", "woni : ----------", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD

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
    void 자동차_이름_생성() {
        Car car = new Car("test");
        assertThat(car.getName()).isEqualTo("test");
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
