package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.dto.RacingCarDto;
import racingcar.dto.RacingGameRq;
import racingcar.dto.RacingGameRs;
import racingcar.view.output.OutputView;

public class RacingGameController {
    private final RacingGame racingGame;
    private final OutputView outputView;

    public RacingGameController(RacingGame racingGame, OutputView outputView) {
        this.racingGame = racingGame;
        this.outputView = outputView;
    }

    public void startRacingGame(List<String> carNames, long numberOfAttempts) {

        RacingGameRq racingGameRq = createRacingGameRq(carNames, numberOfAttempts);

        if (cannotStartGame(numberOfAttempts, racingGameRq.getRacingCarDtoList())) {
            return;
        }

        while (numberOfAttempts-- > 0) {
            RacingGameRs racingGameRs = startSingleGame(racingGameRq);
            racingGameRq = updateRacingGameRq(racingGameRs);
        }

        outputView.printWinners(racingGameRq.getRacingCarDtoList());
    }

    private RacingGameRq updateRacingGameRq(RacingGameRs racingGameRs) {
        return RacingGameRq.valueOf(racingGameRs.getRacingCarDtoList(), racingGameRs.getLeftNumberOfAttempts());
    }

    private RacingGameRq createRacingGameRq(List<String> carNames, long numberOfAttempts) {
        outputView.printExecutionResultMent();
        return RacingGameRq.valueOf(createRacingCarDtos(carNames), numberOfAttempts);
    }

    private List<RacingCarDto> createRacingCarDtos(List<String> carNames) {
        return carNames.stream().map(carName -> new RacingCarDto(carName, 0)).toList();
    }

    private boolean cannotStartGame(long numberOfAttempts, List<RacingCarDto> racingCarDtos) {
        if (numberOfAttempts == 0) {
            outputView.printExecutionResult(racingCarDtos);
            outputView.printWinners(racingCarDtos);
            return true;
        }
        return false;
    }

    public RacingGameRs startSingleGame(RacingGameRq racingGameRq) {
        RacingGameRs racingGameRs = racingGame.startGame(racingGameRq);
        outputView.printExecutionResult(racingGameRs.getRacingCarDtoList());
        return racingGameRs;
    }
}
