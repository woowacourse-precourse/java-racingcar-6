package racingcar.gameplayer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.carfactory.Car;
import racingcar.carfactory.CarFactory;
import racingcar.service.GameService;
import racingcar.service.IoService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GamePlayerTest {
    GamePlayer gamePlayer;
    CarFactory carFactory;
    List<Car> cars;
    ByteArrayOutputStream capture;
    PrintStream printStream;

    @BeforeEach
    void setUp() {
        GameService gameService = mock(GameService.class);
        when(gameService.randomNumber())
                .thenReturn(5, 7, 0, 1, 4, 7, 5, 8, 4, 5, 2, 3);
        carFactory = new CarFactory();
        gamePlayer = new GamePlayer(
                carFactory, gameService, new IoService());

        List<String> carNames = new ArrayList<>(Arrays.asList("nuri", "kyoju", "hwang"));
        cars = carFactory.createCars(carNames);

        capture = new ByteArrayOutputStream();
        printStream = new PrintStream(capture);

        System.setOut(printStream);
    }


    @Test
    void randomAdvanceAll() {
        gamePlayer.randomAdvanceAll(cars);

        Assertions.assertThat(cars.stream().mapToInt(Car::getLocation))
                .contains(0, 1, 1);
    }

    @Test
    void oneTurnTest() {
        gamePlayer.oneTurn(cars);
        Assertions.assertThat(capture.toString())
                .contains("nuri : -", "kyoju : -", "hwang :");
    }

    @Test
    void GamePlayerTest() {
        gamePlayer.playGame(4, cars);
        Assertions.assertThat(capture.toString())
                .contains("nuri : -", "kyoju : -", "hwang :", "nuri : ---", "kyoju : ---", "hwang : --");
    }

    @Test
    void GameStartTest(){
        System.setIn(new ByteArrayInputStream(gameInput().getBytes()));
        gamePlayer.startGame();
        Assertions.assertThat(capture.toString())
                .contains("nuri : -", "kyoju : -", "hwang :", "nuri : ---", "kyoju : ---", "hwang : --");
    }
    String gameInput(){
        return "nuri,kyoju,hwang\n4";
    }

}