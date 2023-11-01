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



    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public GameDto createGame() {
        IOService.printNoticeln(IOService.START);
        String nameList=IOService.inputCreate();
        IOService.printNoticeln(IOService.COUNT);
        Integer playCount = Integer.parseInt(IOService.inputCount());

        return gameService.initGame(nameList, playCount);
    }

    public void gameStart(GameDto request) {
        IOService.printNoticeln(IOService.RESULT);
        for (int i = 0; i < request.getPlayCount(); i++) {
            gameService.processGame(request);
            gameService.printResult(request);
        }
    }

    public void printResult(GameDto request) {
        gameService.resultPrint(request);

    }

}
