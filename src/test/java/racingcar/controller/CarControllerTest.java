package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.manager.controller.CarController;
import racingcar.manager.model.Car;

public class CarControllerTest {
    private final CarController carController = new CarController();

    @AfterEach
    void closeConsole(){
        Console.close();
    }
    @Test
    void 차량_리스트_반환_테스트(){

        String carNames = "pobi,woni,jun";

        InputStream in = new ByteArrayInputStream(carNames.getBytes());
        System.setIn(in);
        List<Car> cars = carController.getCars();

        assertThat(cars).extracting("carName").contains("pobi", "woni", "jun");
        assertThat(cars).extracting("moveCount").containsOnly(0);

    }
}
