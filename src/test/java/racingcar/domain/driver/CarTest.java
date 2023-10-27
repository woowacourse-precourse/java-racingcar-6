package racingcar.domain.driver;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    
    @DisplayName("자동차는 숫자가 명령숫자가 4이상일 경우 전진한다.")
    @Test
    void moveForward() {
        //given
        Car car = new Car();
        int beforeMovementCount = car.getMovementCount();
        int commandNumber = 4;

        //when
        car.moveForward(commandNumber);
    
        //then
        int afterMovementCount = car.getMovementCount();
        Assertions.assertThat(afterMovementCount).isGreaterThan(beforeMovementCount);
    }

}
