package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("주어진 랜덤 값이 3초과면 1 만큼 전진한다.")
    @Test
    void moveForwardIfNumberOverThree() {
        //given
        Car junCar = new Car("jun");
        Integer beforeDistance = junCar.getTravelDistance();
        int randomNumberOverThree = 4;

        //when
        junCar.moveForward(randomNumberOverThree);

        //then
        int movingStep = junCar.getTravelDistance() - beforeDistance;
        assertThat(movingStep).isEqualTo(Car.ONE_STEP);
    }

    @DisplayName("주어진 랜덤 값이 4미만이면 전진하지 않는다.")
    @Test
    void moveForwardIfNumberUnderFour() {
        //given
        Car junCar = new Car("jun");
        Integer beforeDistance = junCar.getTravelDistance();
        int randomNumberUnderFour = 3;

        //when
        junCar.moveForward(randomNumberUnderFour);

        //then
        int movingStep = junCar.getTravelDistance() - beforeDistance;
        assertThat(movingStep).isZero();
    }

}