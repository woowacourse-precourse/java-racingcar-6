package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.model.Car;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차이름_공백() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(" ", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 랜덤값으로_전진() {
        Car car = new Car("test", 0);
        car.carDrive(4);
        assertThat(car).extracting("count").isEqualTo(1);
    }

    @Test
    void 랜덤값으로_정지() {
        Car car = new Car("test", 0);
        car.carDrive(3);
        assertThat(car).extracting("count").isEqualTo(0);
    }

    @Test
    void 횟수가_너무_클때() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,java", "2147483648"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 우승자가_두명이상() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
            },
            MOVING_FORWARD, MOVING_FORWARD
        );
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
