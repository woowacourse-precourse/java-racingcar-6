package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import racingcar.Application;

import java.lang.reflect.Field;
import java.util.List;

public class CarTest extends NsTest {
    @Test
    void 생성자_테스트() {
        Car car = new Car("k-5");

        assertEquals("k-5", car.getName());
    }

    @Test
    void 차_이름_호출_메소드() {
        String testCarName = "k-3";
        Car car = new Car(testCarName);

        assertEquals(car.getName(), testCarName);
    }

    @Test
    void 차_현재_위치_호출_메소드() throws NoSuchFieldException, IllegalAccessException {
        int testCarPosition = 3;
        Car car = new Car("k-3");

        Field currentPositionField = Car.class.getDeclaredField("currentPosition");
        currentPositionField.setAccessible(true);
        currentPositionField.set(car, testCarPosition);

        assertEquals(car.getCurrentPosition(), testCarPosition);
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
