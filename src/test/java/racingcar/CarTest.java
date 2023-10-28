package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import racingcar.model.Car;

public class CarTest extends NsTest {
    @Test
    void testConstructorWithValidName() {
        Car car = new Car("Car1");
        assertEquals("Car1", car.getName());
    }

    @Test
    void testConstructorWithInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> new Car("  "));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
