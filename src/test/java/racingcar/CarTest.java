package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest extends NsTest {

    private Car car;
    private static final String CAR_NAME = "yujin";
    private static final String INVALID_CAR_NAME = "yujin123";

    @BeforeEach
    void setUp() {
        car = new Car(CAR_NAME);
    }

    @Test
    void position_0_으로_초기화() {
        assertEquals(0, car.getPosition());
    }
    @Test
    void 한_칸_앞으로_전진() {
        car.move();
        assertEquals(1, car.getPosition());
    }

    @Test
    void 현재_위치_출력() {
        for(int i=0; i<3; i++)
            car.move();

        runMain();
        assertThat(output()).isEqualTo(CAR_NAME + " : ---");
    }

    @Test
    void 길이_초과_자동차_이름_exception() {
        assertThrows(IllegalArgumentException.class, () -> new Car(INVALID_CAR_NAME));
    }

    @Override
    protected void runMain() {
        car.printCurrentPosition();
    }
}