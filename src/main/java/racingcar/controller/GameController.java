package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.IO.IOService;
import racingcar.dto.CarDto;
import racingcar.dto.GameDto;
import racingcar.entity.Game;
import racingcar.service.CarService;
import racingcar.service.GameService;

public class GameController {

    private GameService gameService;
    private CarService carService;

    private IOService ioService;


    public GameController(GameService gameService, CarService carService, IOService ioService) {
        this.gameService = gameService;
        this.carService = carService;
        this.ioService = ioService;
    }

    public GameDto createGame() {
        ioService.printNoticeln(IOService.START);
        String nameList=ioService.inputCreate();
        ioService.printNoticeln(IOService.COUNT);
        Integer playCount = Integer.parseInt(ioService.inputCreate());

        return gameService.initGame(nameList, playCount);
    }

    public void gameStart(GameDto request) {
        for (int i = 0; i < request.getPlayCount(); i++) {
            gameService.processGame(request);
            gameService.printResult(request);
        }
    }

    public void printResult(GameDto request) {
        gameService.resultPrint(request);

    }

}
