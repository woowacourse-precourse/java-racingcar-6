package racingcar.service;

import racingcar.repository.GameRepository;

public class GameService {

    private GameRepository gameRepository;
    private CarService carService;

    public GameService(GameRepository gameRepository, CarService carService) {
        this.gameRepository = gameRepository;
        this.carService = carService;
    }
}
