package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void 객체_전진() {
        Car car = new Car("test");
        car.tryMove(4);
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @Test
    void 객체_멈춤() {
        Car car = new Car("test");
        car.tryMove(3);
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @Test
    void 이동거리_변화_여부() {
        Car car = new Car("test");
        car.tryMove(4); // 자동차를 한 번 전진시킵니다.
        assertThat(car.getMoveDistance()).isEqualTo("-");

        car.tryMove(4); // 자동차를 다시 한 번 전진시킵니다.
        assertThat(car.getMoveDistance()).isEqualTo("--");

        car.tryMove(3); // 자동차를 정지시킵니다. 이동 거리는 변하지 않습니다.
        assertThat(car.getMoveDistance()).isEqualTo("--");
    }

    @Test
    public void 이동횟수_증가_여부() {
        Car car = new Car("test");
        int initialMoveCount = car.getMoveCount();
        car.tryMove(Randoms.pickNumberInRange(0, 9));
        assertTrue(car.getMoveCount() >= initialMoveCount);
    }

    @Test
    void 횟수_입력이_유효하지_않을_때_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> {
            runException("car1,car2,car3", "not a number");
        });
        System.out.println("예외가 발생해서 테스트가 성공했습니다.");

        assertThrows(IllegalArgumentException.class, () -> {
            runException("car1,car2,car3", "-1");
        });
        System.out.println("예외가 발생해서 테스트가 성공했습니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
