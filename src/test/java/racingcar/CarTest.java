package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_전진() throws NoSuchFieldException, IllegalAccessException {
        Car pobi = Car.registerCar("pobi");
        pobi.moveForwardCar();

        Field field = Car.class.getDeclaredField("distance");
        field.setAccessible(true);
        Integer distance = Integer.parseInt(field.get(pobi).toString());
        Assertions.assertEquals(distance, 1);
    }

    @Test
    void 자동차_생성() throws NoSuchFieldException, IllegalAccessException {
        Car pobi = Car.registerCar("pobi");
        Field field = Car.class.getDeclaredField("name");
        field.setAccessible(true);
        String carName = field.get(pobi).toString();
        Assertions.assertEquals(carName, "pobi");
    }
}