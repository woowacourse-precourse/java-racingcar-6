package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import racingcar.Application;

import java.lang.reflect.Field;
import java.util.List;

public class CarTest extends NsTest {
    private Car testCar;
    @BeforeEach
    void 셋팅() {
        testCar = new Car("k-5");
    }

    @Test
    void 차_이름_호출_메소드() {
        String testCarName = "k-5";

        assertEquals(testCar.getName(), testCarName);
    }

    @Test
    void 차_현재_위치_호출_메소드() throws NoSuchFieldException, IllegalAccessException {
        int testCarPosition = 3;

        Field currentPositionField = Car.class.getDeclaredField("currentPosition");
        currentPositionField.setAccessible(true);
        currentPositionField.set(testCar, testCarPosition);

        assertEquals(testCar.getCurrentPosition(), testCarPosition);
    }

    @Test
    void 차_이동_기능_메소드() {

    }

    @Test
    void 차_이름_공백_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> new Car("  "));
    }

    @Test
    void 차_이름_길이_초과_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> new Car(" 123141123"));
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
