package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import racingcar.Application;

public class CarTest extends NsTest {
    @Test
    void 생성자_테스트() {
        Car car = new Car("k-5");
        assertEquals("k-5", car.getName());
    }

    @Test
    void 이름_공백_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> new Car("  "));
    }

    @Test
    void 이름_길이_초과_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> new Car(" 123141123"));
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
