package racingcar.domain.driver;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    
    @DisplayName("자동차는 숫자가 명령숫자가 4이상일 경우 전진한다.")
    @Test
    void moveForward() {
        //given
        Car car = new Car("test");
        int beforeMovementCount = car.getMovementCount();
        int commandNumber = 4;

        //when
        car.moveForward(commandNumber);
    
        //then
        int afterMovementCount = car.getMovementCount();
        Assertions.assertThat(afterMovementCount).isGreaterThan(beforeMovementCount);
    }

    @DisplayName("자동차는 숫자가 명령숫자가 4보다 작을 경우 전진하지 않는다.")
    @Test
    void cannotMoveForward() {
        //given
        Car car = new Car("test");
        int beforeMovementCount = car.getMovementCount();
        int commandNumber = 3;

        //when
        car.moveForward(commandNumber);

        //then
        int afterMovementCount = car.getMovementCount();
        Assertions.assertThat(afterMovementCount).isEqualTo(beforeMovementCount);

    }

}
