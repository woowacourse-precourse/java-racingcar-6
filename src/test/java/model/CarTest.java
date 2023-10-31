package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7,8,9})
    void 난수가_4이상이면_전진_4미만이면_정지(int randomNumber) {
        Car car = new Car();
        int distanceBeforeMove = car.getDistance();
        car.move(randomNumber);
        if(randomNumber>=4) {
            assertEquals(distanceBeforeMove+1,car.getDistance());
        } else {
            assertEquals(distanceBeforeMove,car.getDistance());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1", "car2", "car3"})
    void 자동차에_이름을_부여할_수_있다(String name) {
        Car car = new Car(name);
        assertEquals(name,car.getName());
    }
}