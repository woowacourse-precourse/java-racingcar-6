package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.dto.CarDto;

class GameServiceTest {

    List<String> carNames;
    private Game game;
    private Cars cars;
    private GameService gameService = new GameService();


    @Test
    void Cars를_CarDto_리스트로_변환() {
        List<String> carNames = new ArrayList<>();
        carNames.add("a");
        carNames.add("b");
        cars = Cars.createNewCars(carNames);

        assertThat(gameService.convertCarsToCarDtoList(cars))
                .hasOnlyElementsOfType(CarDto.class);
    }

    @Test
    void 라운드_결과는_CarDto_리스트_반환() {
        List<String> carNames = new ArrayList<>();
        carNames.add("a");
        carNames.add("b");
        cars = Cars.createNewCars(carNames);
        game = Game.createNewGame(3);

        List<CarDto> roundResult = gameService.getRoundResult(cars, game);

        assertThat(roundResult).hasOnlyElementsOfType(CarDto.class);
    }
}