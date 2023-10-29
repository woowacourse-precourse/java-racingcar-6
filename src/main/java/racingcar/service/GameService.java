package racingcar.service;

import racingcar.entity.Car;
import racingcar.entity.Game;
import racingcar.repository.GameRepository;

import java.util.Arrays;
import java.util.List;

public class GameService {

    private GameRepository gameRepository;
    private CarService carService;

    public GameService(GameRepository gameRepository, CarService carService) {
        this.gameRepository = gameRepository;
        this.carService = carService;
    }

    public Game initGame(String nameInput, Integer playCount) {
        Game game = gameRepository.save(playCount);
        List<String> nameList = Arrays.stream(nameInput.split(",")).toList();
        for (String name : nameList) {
            game.addCar(carService.carCreate(name));
        }
        return game;
    }

    public void processGame(Game game) {
        for (String carName : game.getCarNameList()) {
            goOrStop(game,carName);
        }
    }


    private void goOrStop(Game game, String carName) {
        if (game.carGoOrStop()) carService.go(carName);
    }

}
