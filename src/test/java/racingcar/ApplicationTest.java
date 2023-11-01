package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

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
    void 전진_테스트() {
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getDistance()).isEqualTo(1);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 정지_테스트() {
        Car car = new Car("pobi");
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.getDistance()).isEqualTo(0);
                },
                STOP
        );
    }

    @Test
    void 우승자_계산_테스트() {
        // given
        Car pobi = new Car("pobi");
        Car hee = new Car("hee");
        Car choi = new Car("choi");

        List<Car> cars = List.of(pobi, hee, choi);

        assertRandomNumberInRangeTest(
                () -> {
                    pobi.move();
                    hee.move();
                    choi.move();

                    List<Car> winners = Car.decideWinners(cars);

                    assertThat(winners).contains(pobi, hee);
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
