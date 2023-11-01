package racingcar.Model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    private Car car;
    @Test
    public void 자동차_이름_유효성_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Car("lucky5");
        });
    }

    @Test
    public void 자동차_이동_테스트() {
        car = new Car("luda");
        car.move(3);
        assertEquals(0, car.getPosition());

        car.move(4);
        assertEquals(1, car.getPosition());
    }

    @Test
    public void 자동차_객체_테스트() {
        car = new Car("luda");
        assertEquals("luda", car.getName());
    }

}
