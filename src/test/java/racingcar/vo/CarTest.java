package racingcar.vo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp(){
        car = new Car("semin",List.of(TRUE,FALSE,TRUE,TRUE,FALSE));
    }

    @Test
    void toChar_각_이동마다_올바른_결과를_출력하는지_확인한다() {
        Assertions.assertEquals("semin : ",car.toString());

        car.move();
        Assertions.assertEquals("semin : -",car.toString());

        car.move();
        Assertions.assertEquals("semin : -",car.toString());

        car.move();
        Assertions.assertEquals("semin : --",car.toString());

        car.move();
        Assertions.assertEquals("semin : ---",car.toString());

        car.move();
        Assertions.assertEquals("semin : ---",car.toString());
    }

}