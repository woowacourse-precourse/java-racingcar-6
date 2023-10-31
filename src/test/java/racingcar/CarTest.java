package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.constant.initial.CarPosition;
import racingcar.constant.message.GameMessage;
import racingcar.domain.Car;
import racingcar.domain.CarDto;

class CarTest {

    private Car car;

    @BeforeEach
    void 설정() {
        car = new Car("테스트카");
    }

    @Test
    void 새_자동차_초기위치_테스트() {
        assertEquals(CarPosition.INITIAL_POSITION.getValue(), car.getPosition());
    }

    @Test
    void 자동차_움직임_테스트() {
        car.move();
        assertEquals(CarPosition.INITIAL_POSITION.getValue() + 1, car.getPosition());
    }

    @Test
    void 자동차_Dto_변환_테스트() {
        car.move();
        CarDto dto = car.toDto();

        String expectedStatus = "테스트카" + GameMessage.COLON.getMessage() +
                GameMessage.DASH.getMessage().repeat(CarPosition.INITIAL_POSITION.getValue() + 1);

        assertEquals(expectedStatus, dto.getStatus());
    }

}
