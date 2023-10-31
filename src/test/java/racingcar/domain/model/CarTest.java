package racingcar.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {


    @Test
    void move가_호출될_시_position_이_증가되는지() {
        Car car = new Car("pobi");
        int initPosition = car.getPostion();
        car.move();
        assertEquals(car.getPostion(), initPosition + 1);
    }


}