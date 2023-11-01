package racingcar.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import static racingcar.domain.Car.createCarByCarName;
import static racingcar.domain.Game.createGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.dto.CarResult;

class GameServiceTest {
    private GameService gameService;

    @BeforeEach
    void setup() {
        CarService carService = new CarService();
        gameService = new GameService(carService);
    }

    @Test
    @DisplayName("입력된 차량이름과 횟수가 게임으로 등록되고도 같은 값이 나와야한다.")
    void testSettingGame() {
        //given
        List<String> carNameList = Arrays.asList("Car1", "Car2", "Car3");
        int count = 5;

        //when
        Game game = gameService.settingGame(carNameList, count);

        //then
        List<String> carNameByGame = game.getCarList().stream().map(Car::getName).toList();

        assertThat(carNameByGame).isEqualTo(carNameList);
        assertThat(game.getCount()).isEqualTo(count);
    }
    @Test
    @DisplayName("3개의 차가 게임을 시작하면, 3개의 결과 값이 나와야한다.")
    void testStartGame() {
        //given
        List<Car> carList = Arrays.asList(createCarByCarName("Car1"), createCarByCarName("Car2"),
                createCarByCarName("Car3"));
        Game game = createGame(carList, 5);

        //when
        List<CarResult> gameResults = gameService.startGame(game);

        //then
        assertEquals(3, gameResults.size());
    }

    @Test
    @DisplayName("3개의 차량이 게임을 시작해서 차량 위치가 업데이트 되면, 우승자가 존재해야한다.")
    public void testDetermineWinner() {
        //given
        List<Car> carList = Arrays.asList(createCarByCarName("Car1"), createCarByCarName("Car2"),
                createCarByCarName("Car3"));

        Game game = createGame(carList, 5);
        game.updateCarsMove();

        //when
        List<String> winners = gameService.determineWinner(game);

        //then
        assertFalse(winners.isEmpty());

    }
}
