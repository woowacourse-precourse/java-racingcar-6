package racingcar.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarControllerTest {

    CarController carController;

    @BeforeEach
    void init() {
        carController = new CarController();
    }

    @Test
    @DisplayName("입력값 테스트 1 - 이름이 5글자 이상일때 테스트")
    void inputTest1() {
        //given
        String userCars = "boot, jpa, sql, spring";
        String userCount = "5";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            carController.createRacingGame(userCars, userCount);
        });
    }

}