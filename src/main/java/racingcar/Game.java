package racingcar;

import racingcar.domain.dto.RoundResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Game {

    private final GameService gameService;
    private final InputView inputView;
    private final OutputView outputView;

    public Game(GameService gameService, InputView inputView, OutputView outputView){
        this.gameService = gameService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void doGame(){
        //Car 생성
        String carNames = inputView.start();
        gameService.makeCars(carNames);

        //라운드 입력
        int round = inputView.readRound();
        outputView.printExecutionResultString();
        for(int i=0; i<round; i++){
            RoundResult roundResult = gameService.forward();
            outputView.printRoundResult(roundResult);
        }

        List<String> winners = gameService.selectWinners();
        outputView.printWinners(winners);

    }

}
