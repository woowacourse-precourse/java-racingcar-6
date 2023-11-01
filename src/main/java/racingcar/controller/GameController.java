package racingcar.controller;

import racingcar.domain.CarPlayer;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final GameService gameService = new GameService();

    public void runGame(){
        String cars = inputView.inputCarNames();
        List<String> carList = gameService.carNameStringToList(cars);

        gameService.validateNames(carList);

        List<CarPlayer> playerList = gameService.saveCarNames(carList);

        String countInput = inputView.inputTryCount();

        gameService.validateCount(countInput);

        int count = gameService.countStringToInt(countInput);

        System.out.println();
        resultGame(playerList, count);
    }

    public void resultGame(List<CarPlayer> playersList, int count){
        System.out.println("실행 결과");
        for(int i = 0; i < count; i++){
            gameService.updateCarScore(playersList);
            outputView.outputRaceProgress(playersList);
        }
        String winner = gameService.checkFinalScores(playersList);
        outputView.outputWinners(winner);
    }
}
