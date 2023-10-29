package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;
    @BeforeEach
    void setUp(){
        car = new Car();
    }
    @Test
    void 숫자가_일정값을_넘으면_전진할수있다(){
        Boolean forwardStatus = car.moveForwardIfSpeedIsExceedThreshold();
        Assertions.assertEquals(forwardStatus,true);
    }
    @Test
    void 숫자가_일정값을_넘지못하면_전진할수없다(){
        Boolean forwardStatus = car.moveForwardIfSpeedIsExceedThreshold();
        Assertions.assertEquals(forwardStatus,false);
    }

}
