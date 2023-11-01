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
        List<RoundResult> roundResults = gameService.forwardStart(round);
        outputView.printRoundResult(roundResults);

        List<String> winners = gameService.selectWinners();
        outputView.printWinners(winners);

    }

}
