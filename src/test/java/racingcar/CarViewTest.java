package racingcar;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarViewTest {

    private void setCarPosition(Car car, int position) throws NoSuchFieldException, IllegalAccessException {
        Field positionField = Car.class.getDeclaredField("position");
        positionField.setAccessible(true);
        positionField.set(car, position);
    }

    @Test
    void testDisplayPositionShouldReturnCorrectFormat() throws Exception {
        Car car = new Car("pobi");
        setCarPosition(car,2);

        String display = CarView.displayPosition(car);

        assertEquals("pobi : --", display);
    }
}
