package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.TestConsts;

import java.math.BigInteger;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static final BigInteger TEMP_ID = BigInteger.ZERO;

    @Test
    @DisplayName("차를 생성하는 기능 확인")
    void createCar() {
        // given
        String carName = "abc";

        // when
        Car createdCar = Car.createCar(TEMP_ID, carName);

        // then
        assertThat(createdCar).isNotNull();
        assertThat(createdCar).isExactlyInstanceOf(Car.class);
    }

    @Test
    @DisplayName("자동차는 상태를 CarResultDto에 담아서 반환한다.")
    void carResultDtoTest() {
        // given
        Car myCar = Car.createCar(TEMP_ID, "kyeo");

        // when
        Car.CarResultDto carResultDto = myCar.createCarResultDto();
        long initDistance = 0L;

        // then
        assertThat(carResultDto.getDistance()).isEqualTo(initDistance);
        assertThat(carResultDto.getName()).isEqualTo("kyeo");
    }

    @Test
    @DisplayName("랜덤의 결과가 4 이상이면 한 칸씩 전진한다.")
    void movingCar() {
        Car myCar = Car.createCar(TEMP_ID, "kyeo");
        assertRandomNumberInRangeTest(
                () -> {
                    myCar.raceOneRound();
                    Car.CarResultDto carResultDto = myCar.createCarResultDto();
                    assertThat(carResultDto.getDistance()).isEqualTo(1L);
                }, TestConsts.FORWARD
        );

        assertRandomNumberInRangeTest(
                () -> {
                    myCar.raceOneRound();
                    Car.CarResultDto carResultDto = myCar.createCarResultDto();
                    assertThat(carResultDto.getDistance()).isEqualTo(2L);
                }, TestConsts.FORWARD
        );
    }

    @Test
    @DisplayName("랜덤의 결과가 3 이하면 움직이지 않는다.")
    void stoppedCar() {
        Car myCar = Car.createCar(TEMP_ID, "kyeo");
        assertRandomNumberInRangeTest(
                () -> {
                    myCar.raceOneRound();
                    Car.CarResultDto carResultDto = myCar.createCarResultDto();
                    assertThat(carResultDto.getDistance()).isEqualTo(0L);
                }, TestConsts.STOP
        );
    }
}