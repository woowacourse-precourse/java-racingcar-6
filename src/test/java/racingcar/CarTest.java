package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
public class CarTest{
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    Car testCar = new Car("test");
    @Test
    void 이름_출력(){
        assertThat(testCar.announceName()).contains("test");
    }
    @Test
    void 전진_정지(){
        assertRandomNumberInRangeTest(
            () -> {
                assertThat(testCar.tryMove()).isTrue();
                assertThat(testCar.tryMove()).isFalse();
            },MOVING_FORWARD,STOP
        );
    }

}
