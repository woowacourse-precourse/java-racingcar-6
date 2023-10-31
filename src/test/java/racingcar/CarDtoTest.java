package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.constant.message.GameMessage;
import racingcar.domain.CarDto;

class CarDtoTest {

    @Test
    void 자동차_상태_문자열_테스트() {
        CarDto dto = new CarDto("테스트카", 3);
        String expectedStatus = "테스트카" + GameMessage.COLON.getMessage() + GameMessage.DASH.getMessage().repeat(3);
        assertEquals(expectedStatus, dto.getStatus());
    }
}
