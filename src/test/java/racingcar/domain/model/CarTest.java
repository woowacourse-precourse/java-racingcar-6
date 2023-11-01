package racingcar.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {


    @Test
    void move가_호출될_시_position_이_증가되는지() {
        Car car = new Car("pobi");
        int initPosition = car.getPosition();
        car.move();
        assertEquals(car.getPosition(), initPosition + 1);
    }


}