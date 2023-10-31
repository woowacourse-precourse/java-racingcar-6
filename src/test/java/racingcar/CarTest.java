package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import org.mockito.MockedStatic;
import org.mockito.MockedStatic.Verification;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;



public class CarTest {
    private Car car;
    private Verification verificationPickNumberInRange =
            () -> Randoms.pickNumberInRange(anyInt(),anyInt());
    final MockedStatic<Randoms> mockingRandomClass = mockStatic(Randoms.class);

    @BeforeEach
    void setUp(){
        car = new Car();
    }
    @AfterEach
    void setDown(){mockingRandomClass.close();}

    @Test
    void 최소값과_최대값사이_랜덤한_숫자를_생성한다(){

        int speed = car.generateRandomSpeed();

        Assertions.assertTrue(speed>= Config.MINIMUM_VALUE && speed<=Config.MAXIMUM_VALUE);
    }

    @Test
    void 숫자가_일정값을_넘으면_전진할수있다(){

        mockingRandomClass.when(verificationPickNumberInRange)
                .thenReturn(Config.FORWARD_THRESHOLD+1);

        Assertions.assertEquals(car.checkCanMoveForwardIfSpeedIsExceedThreshold(),true);
    }
    @Test
    void 숫자가_일정값을_넘지못하면_전진할수없다(){

        mockingRandomClass.when(verificationPickNumberInRange)
                .thenReturn(Config.FORWARD_THRESHOLD-1);

        Assertions.assertEquals(car.checkCanMoveForwardIfSpeedIsExceedThreshold(),false);
    }
}
