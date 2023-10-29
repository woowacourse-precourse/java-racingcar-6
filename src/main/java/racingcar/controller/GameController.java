package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.CarDto;
import racingcar.entity.Game;
import racingcar.service.CarService;
import racingcar.service.GameService;

public class GameController {

    private GameService gameService;
    private CarService carService;


    public GameController(GameService gameService,CarService carService) {
        this.gameService = gameService;
        this.carService = carService;
    }

    public void gameStart() {
        String inp1= Console.readLine();
        String inp2 = Console.readLine();
        Game game = gameService.initGame(inp1, Integer.parseInt(inp2));
        for (int i = 0; i < game.getPlayCount(); i++) {
            gameService.processGame(game);
            printResult(game);
        }
    }

    private void printResult(Game game) {
        for (String name : game.getCarNameList()) {
            CarDto carDto = carService.getCartInfo(name);
            System.out.println(carDto.getName()+" "+ carDto.getScore());
        }

    }

}
