package racingcar.domain;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.Consts.MOVEMENT_CRITERIA;

class CarTest {

    private static final int ANOTHER_MOVING_RESULT = MOVEMENT_CRITERIA + 3;
    private static final int STOPPED_RESULT = MOVEMENT_CRITERIA - 1;

    @Test
    @DisplayName("차를 생성하는 기능 확인")
    void createCar() {
        String carName = "abc";

        Car createdCar = Car.createCar(carName);

        assertThat(createdCar).isNotNull();
        assertThat(createdCar).isExactlyInstanceOf(Car.class);
    }

    @Test
    @DisplayName("랜덤의 결과가 4 이상이면 한 칸씩 전진한다.")
    void movingCar() {
        Car pobiCar = Car.createCar("pobi");
        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    BigInteger distanceResult = pobiCar.raceOneRoundAndGetDistance();
                    assertThat(distanceResult).isEqualTo(BigInteger.ONE);
                },
                MOVEMENT_CRITERIA
        );

        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    BigInteger distanceResult = pobiCar.raceOneRoundAndGetDistance();
                    assertThat(distanceResult).isEqualTo(BigInteger.TWO);
                },
                ANOTHER_MOVING_RESULT
        );
    }

    @Test
    @DisplayName("랜덤의 결과가 3 이하면 움직이지 않는다.")
    void stoppedCar() {
        Car pobiCar = Car.createCar("pobi");
        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    BigInteger distanceResult = pobiCar.raceOneRoundAndGetDistance();
                    assertThat(distanceResult).isEqualTo(BigInteger.ZERO);
                },
                STOPPED_RESULT
        );
    }
}