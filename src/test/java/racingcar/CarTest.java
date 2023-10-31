package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.car.Car;
import racingcar.configs.Config;
import racingcar.mocking.RandomsMocking;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp(){
        car = new Car();
    }
    @Test
    void 최소값과_최대값사이_랜덤한_숫자를_생성한다(){

        int speed = car.generateRandomSpeed();

        Assertions.assertTrue(speed>= Config.MINIMUM_VALUE && speed<=Config.MAXIMUM_VALUE);
    }

    @Test
    void 숫자가_일정값을_넘으면_전진할수있다(){

        RandomsMocking.fixPickNumberInRangeOverThreshold(
            () -> {
                Assertions.assertEquals
                    (car.checkCanMoveForwardIfSpeedIsExceedThreshold(),true);
            }
        );
    }
    @Test
    void 숫자가_일정값을_넘지못하면_전진할수없다(){

        RandomsMocking.fixPickNumberInRangeUnderThreshold(
            () -> {
                Assertions.assertEquals
                    (car.checkCanMoveForwardIfSpeedIsExceedThreshold(),false);
            }
        );
    }
}
