package racingcar.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.IOTest;
import racingcar.domain.Car;

class GameInputControllerTest extends IOTest {

    GameInputController inputController;

    @BeforeEach
    void setUp() {
        inputController = new GameInputController();
        inputController.settingController();
    }

    @AfterEach
    void after() {
        clean();
    }

    @Test
    void requestNames_메서드로_자동차_이름_지정() {
        //given
        systemIn("seori,snow,joy");
        //when
        inputController.requestNames();
        ArrayList<Car> cars = inputController.cars.getCarList();
        //then
        assertEquals(cars.size(), 3);
    }

    @Test
    void requestTryNumber_메서드로_게임_진행_횟수_지정() {
        //given
        systemIn("2");
        //when
        inputController.requestTryNumber();
        int chanceNumber = inputController.game.getChanceNumber();
        //then
        assertEquals(chanceNumber, 2);
    }

}