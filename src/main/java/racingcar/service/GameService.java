package racingcar.service;

import racingcar.dto.GameDto;
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

    public GameDto initGame(String nameInput, Integer playCount) {
        Game game = new Game(playCount);
        Long gameId=gameRepository.save(game);

        List<String> nameList = Arrays.stream(nameInput.split(",")).toList();
        for (String name : nameList) {
            game.addCar(carService.carCreate(name));
        }
        return new GameDto(gameId,playCount);
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
