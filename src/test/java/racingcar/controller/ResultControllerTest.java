package racingcar.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ResultControllerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void showWinnersTest() {
        RacingCars racingCars = new RacingCars();
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");

        racingCars.addCar(car1);
        racingCars.addCar(car2);

        car1.moveForward();

        ResultController resultController = new ResultController(racingCars);
        resultController.showWinners();

        assertThat(outContent.toString().trim()).isEqualTo("최종 우승자 : pobi");
    }
}
