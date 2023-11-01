package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.service.GameService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private static GameService gameService = new GameService();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("자동차 경주 현황 출력 테스트")
    public void printRacingStatus() throws Exception {
        // given
        List<Car> cars = new ArrayList<>();
        Car webCar = new Car("web");
        cars.add(webCar);
        Car iosCar = new Car("ios");
        cars.add(iosCar);
        Car backCar = new Car("back");
        cars.add(backCar);

        // when
        webCar.moveForward();
        iosCar.moveForward();
        iosCar.moveForward();
        backCar.moveForward();

        // then
        OutputView.printRacingGameStatus(cars);
        assertEquals("web : -\nios : --\nback : -\n\n", outContent.toString());

    }

    @Test
    @DisplayName("우승자 출력 테스트")
    public void printWinners() throws Exception {
        // given
        List<Car> cars = new ArrayList<>();
        Car webCar = new Car("web");
        cars.add(webCar);
        Car iosCar = new Car("ios");
        cars.add(iosCar);
        Car backCar = new Car("back");
        cars.add(backCar);

        // when
        webCar.moveForward();
        iosCar.moveForward();
        iosCar.moveForward();
        backCar.moveForward();

        // then
        List<Car> winners = gameService.getWinners(cars);
        OutputView.printWinner(winners);
        assertEquals("최종 우승자 : ios", outContent.toString());

    }

    @Test
    @DisplayName("공동 우승자 출력 테스트")
    public void printCoWinners() throws Exception {
        // given
        List<Car> cars = new ArrayList<>();
        Car webCar = new Car("web");
        cars.add(webCar);
        Car iosCar = new Car("ios");
        cars.add(iosCar);
        Car backCar = new Car("back");
        cars.add(backCar);

        // when
        webCar.moveForward();
        iosCar.moveForward();
        iosCar.moveForward();
        backCar.moveForward();
        backCar.moveForward();

        // then
        List<Car> winners = gameService.getWinners(cars);
        OutputView.printWinner(winners);
        assertEquals("최종 우승자 : ios, back", outContent.toString());

    }

}