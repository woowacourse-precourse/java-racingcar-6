package racingcar.service;

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
        String[] carNames = input.split(",");

        for (String carName : carNames) {
            Car car = Car.create(carName);
            carService.join(car);
        }
    }


}
