package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import org.mockito.Mockito;


public class CarTest {
    private Car car;


    @BeforeEach
    void setUp(){
        car = Mockito.mock(Car.class);
    }
    @Test
    void 숫자가_일정값을_넘으면_전진할수있다(){
        Mockito.when(car.generateRandomSpeed()).thenReturn(5);
        Mockito.when(car.checkCanMoveForwardIfSpeedIsExceedThreshold()).thenCallRealMethod();
        Assertions.assertEquals(car.checkCanMoveForwardIfSpeedIsExceedThreshold(),true);
    }
    @Test
    void 숫자가_일정값을_넘지못하면_전진할수없다(){
        Mockito.when(car.generateRandomSpeed()).thenReturn(1);
        Mockito.when(car.checkCanMoveForwardIfSpeedIsExceedThreshold()).thenCallRealMethod();
        Assertions.assertEquals(car.checkCanMoveForwardIfSpeedIsExceedThreshold(),false);
    }

}
