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
    void 이름이_null인_경우_예외_처리() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(",,", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 우승자_찾는_로직_검증() {
        // 테스트할 RacingCars 객체 생성
        RacingCar car1 = new RacingCar("pobi", 3);
        RacingCar car2 = new RacingCar("woni", 3);
        RacingCar car3 = new RacingCar("jun", 2);
        RacingCar car4 = new RacingCar("hoosa", 1);
        RacingCars racingCars = new RacingCars(List.of(car1, car2, car3, car4));

        List<RacingCar> result = racingCars.findCarsWithMaxDistance();
        // 실행시 pobi, woni 예상
        assertThat(result).containsExactly(car1, car2);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
