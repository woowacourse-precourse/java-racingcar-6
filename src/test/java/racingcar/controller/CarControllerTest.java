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

    @Test
    @DisplayName("입력값 테스트 2 - 이름 입력 값을 구분하는 ,가 2개 이상일 경우 테스트")
    void inputTest2() {
        //given
        String userCars = "boot, jpa,, sql";
        String userCount = "5";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            carController.createRacingGame(userCars, userCount);
        });
    }

    @Test
    @DisplayName("입력값 테스트 3 - 시도하는 횟수가 0일때")
    void inputTest3() {
        //given
        String userCars = "boot, jpa,, sql";
        String userCount = "0";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            carController.createRacingGame(userCars, userCount);
        });
    }

    @Test
    @DisplayName("입력값 테스트 4 - 시도하는 횟수가 0이 아닌 정수일 때")
    void inputTest4() {
        //given
        String userCars = "boot, jpa,, sql";
        String userCount = "-100";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            carController.createRacingGame(userCars, userCount);
        });
    }

}