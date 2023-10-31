package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.CarList.CarDto;
import racingcar.service.RacingService;
import racingcar.service.RankingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingService racingService = new RacingService();
    private final RankingService rankingService = new RankingService();


    public void initRacingGame() {
        String inputRacingRound;

        inputView.printRequestCarName();
        List<String> userInput = inputView.getUserInputCarNames();
        inputView.printRequestRound();
        inputRacingRound = Console.readLine();
        int racingRound = inputView.getUserInputRacingRound(inputRacingRound);
        racingService.setCars(userInput);
        outputView.printResult();
        playRacingGame(racingRound);
    }

    private void playRacingGame(int racingRound) {
        List<CarDto> carDtoList = new ArrayList<>();
        for (int currentRound = 0; currentRound < racingRound; currentRound++) {
            carDtoList = racingService.startRacing();
            outputView.printRoundResult(carDtoList);
        }
        List<String> winner = rankingService.checkWinner(carDtoList);
        outputView.printWinner(winner);
    }
}
