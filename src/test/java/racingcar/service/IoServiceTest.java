package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import racingcar.carfactory.Car;
import racingcar.carfactory.CarFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class IoServiceTest {
    private ByteArrayOutputStream byteArrayOutputStream;
    private PrintStream outputStreamCapture;
    private IoService ioService;
    private CarFactory carFactory;

    GameService gameService;

    public IoServiceTest() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        outputStreamCapture = new PrintStream(byteArrayOutputStream);
        ioService = new IoService();
        carFactory = new CarFactory();
        gameService = new GameService();
    }

    @BeforeEach
    void setUp() {
        System.setOut(outputStreamCapture);
    }

    @Test
    void 차_이름_차수_입력(){
        System.setIn(new ByteArrayInputStream("nuri,kyoju,hwang\n5".getBytes()));
        List<String> carNames = ioService.inputCarNames();
        int totalRound = ioService.inputTurnNumber();
        Assertions.assertThat(carNames).contains("nuri","kyoju","hwang");
        Assertions.assertThat(totalRound).isEqualTo(5);
    }

    @Test
    void printOneTurnResult() {
        InputStream stdInputStream = System.in;
        ioService.printOneTurnResult(setUpCars());
        System.setIn(stdInputStream);
        String result = byteArrayOutputStream.toString().replaceAll("\\s", "");

        Assertions.assertThat(result).isEqualTo("nuri:--KyoJu:-shane:-");
    }

    @Test
    void printWinner() {
        ioService.printWinner(gameService.selectWinner(setUpCars()));
        String result = byteArrayOutputStream.toString().trim();
        Assertions.assertThat(result).isEqualTo("최종 우승자 : nuri");
    }

    private List<Car> setUpCars() {
        List<String> carNames = new ArrayList<>(Arrays.asList("nuri", "KyoJu", "shane"));
        List<Car> cars = new CarFactory().createCars(carNames);

        cars.get(0).advanceOnce();
        cars.get(0).advanceOnce();
        cars.get(1).advanceOnce();
        cars.get(2).advanceOnce();

        return cars;
    }
}