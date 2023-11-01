package racingcar.dto.response;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class MovementDtoTest {
    @Test
    void 경주차_움직임을_올바른형식으로_출력하기() {
        // given
        Car car = new Car(1, "meoru");
        car.updateForwardCount();
        car.updateForwardCount();

        // when
        MovementDto movement = new MovementDto(car);
        String output = movement.createMessage();

        // then
        assertEquals("meoru : --", output);
    }
}