package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarControllerTest {

    @DisplayName("carsCreater(): 유저 입력을 받아 자동차 객체 리스트를 저장하는 메서드 테스트")
    @Test
    void carsCreaterTest() {
        CarController controller = new CarController();
        controller.createCars("붕붕이,부왕이,부르릉");
        assertEquals(controller.carList.get(0).getNameToString(), "붕붕이");
    }
}
