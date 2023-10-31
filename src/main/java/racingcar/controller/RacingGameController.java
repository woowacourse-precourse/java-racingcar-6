package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.dto.RacingCarDto;
import racingcar.dto.RacingGameRq;
import racingcar.dto.RacingGameRs;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class RacingGameController {
    private final RacingGame racingGame;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(RacingGame racingGame, InputView inputView, OutputView outputView) {
        this.racingGame = racingGame;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> carNames = inputView.names();
        long numberOfAttempts = inputView.number();
        List<RacingCarDto> racingCarDtos = carNames.stream()
                .map(carName -> new RacingCarDto(carName, 0)).toList();
        RacingGameRq racingGameRq = RacingGameRq.valueOf(racingCarDtos, numberOfAttempts);
        outputView.printExecutionResultMent();

        while (numberOfAttempts-- > 0) {
            RacingGameRs racingGameRs = startGame(racingGameRq);
            outputView.printExecutionResult(racingGameRs.getRacingCarDtoList());
            racingGameRq = RacingGameRq.valueOf(racingGameRs.getRacingCarDtoList(),
                    racingGameRs.getLeftNumberOfAttempts());
        }

        outputView.printWinners(racingGameRq.getRacingCarDtoList());
    }

    public RacingGameRs startGame(RacingGameRq racingGameRq) {
        return racingGame.startGame(racingGameRq);
    }
}
