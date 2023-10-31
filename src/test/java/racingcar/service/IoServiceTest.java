package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.carfactory.Car;
import racingcar.carfactory.CarFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IoServiceTest {
    private ByteArrayOutputStream byteArrayOutputStream;
    private PrintStream outputStreamCapture;
    private IoService ioService;
    private CarFactory carFactory;

    GameService gameService;

    public IoServiceTest(){
        byteArrayOutputStream = new ByteArrayOutputStream();
        outputStreamCapture = new PrintStream(byteArrayOutputStream);
        ioService = new IoService();
        carFactory = new CarFactory();
        gameService = new GameService();
    }

    @BeforeEach
    void setUp(){
        System.setOut(outputStreamCapture);
    }

    @Test
    void printOneTurnResult(){
        ioService.printOneTurnResult(setUpCars());
        String result = byteArrayOutputStream.toString().replaceAll("\\s","");

        Assertions.assertThat(result).isEqualTo("nuri:--KyoJu:-shane:-");
    }

    @Test
    void printWinner(){
        ioService.printWinner(gameService.selectWinner(setUpCars()));
        String result = byteArrayOutputStream.toString().trim();
        Assertions.assertThat(result).isEqualTo("최종 우승자 : nuri");
    }

    private List<Car> setUpCars(){
        List<String> carNames = new ArrayList<>(Arrays.asList("nuri","KyoJu","shane"));
        List<Car> cars = new CarFactory().createCars(carNames);

        cars.get(0).advanceOnce();
        cars.get(0).advanceOnce();
        cars.get(1).advanceOnce();
        cars.get(2).advanceOnce();

        return cars;
    }
}