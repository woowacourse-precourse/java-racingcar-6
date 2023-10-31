package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final String carNames1 = "bora,dori,nana";
    private static final String carNames2 = "bora,,nana,ddubi";

    @Test
    @DisplayName("from 함수 테스트")
    void 입력_사이에_빈_값이_들어왔을_경우_제거_후_반환_기능_테스트() {
        //given
        Cars cars = Cars.from(carNames2);
        //then
        assertEquals(cars.getCarList().size(), 3);
    }
}
