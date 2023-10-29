package racingcar.service;

import java.util.Arrays;
import racingcar.domain.Car;

public class GameServiceImpl implements GameService {

    private static GameServiceImpl gameService;
    private final CarService carService;

    private GameServiceImpl(CarService carService) { //TODO: 파라미터가 많아질경우 builder 등 고려하기
        this.carService = carService;
    }

    public static GameServiceImpl getInstance(CarService carService) {
        if (gameService == null) {
            gameService = new GameServiceImpl(carService);
        }
        return gameService;
    }

    public void processCarNamesInput(String input) {
        Arrays.stream(input.split(","))
                .map(carName -> Car.create(carName))
                .forEach(car -> carService.join(car));
    }

    private void validateEmptyInput(String input) {


    }
}
