package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.dto.RacingCarDto;
import racingcar.dto.RacingGameRq;
import racingcar.dto.RacingGameRs;
import racingcar.view.ViewResolver;
import racingcar.view.output.OutputView;

public class RacingGameController {
    private final RacingGame racingGame;
    private final OutputView outputView;
    private final ViewResolver viewResolver;

    public RacingGameController(RacingGame racingGame, OutputView outputView, ViewResolver viewResolver) {
        this.racingGame = racingGame;
        this.outputView = outputView;
        this.viewResolver = viewResolver;
    }

    public void startRacingGame(List<String> carNames, long numberOfAttempts) {

        RacingGameRq racingGameRq = createRacingGameRq(carNames, numberOfAttempts);

        while (numberOfAttempts-- > 0) {
            RacingGameRs racingGameRs = startSingleGame(racingGameRq);
            racingGameRq = updateRacingGameRq(racingGameRs);
        }

        outputView.printWinners(resolveWinner(racingGameRq));
    }

    private RacingGameRq createRacingGameRq(List<String> carNames, long numberOfAttempts) {
        outputView.printExecutionResultMent();
        return RacingGameRq.valueOf(createRacingCarDtos(carNames), numberOfAttempts);
    }

    private List<RacingCarDto> createRacingCarDtos(List<String> carNames) {
        return carNames.stream().map(carName -> new RacingCarDto(carName, 0)).toList();
    }

    private RacingGameRs startSingleGame(RacingGameRq racingGameRq) {
        RacingGameRs racingGameRs = racingGame.startGame(racingGameRq);
        outputView.printExecutionResult(resolveSingleResult(racingGameRs));
        return racingGameRs;
    }

    private String resolveSingleResult(RacingGameRs racingGameRs) {
        return viewResolver.singleGameResult(racingGameRs.getRacingCarDtoList());
    }

    private RacingGameRq updateRacingGameRq(RacingGameRs racingGameRs) {
        return RacingGameRq.valueOf(racingGameRs.getRacingCarDtoList(), racingGameRs.getLeftNumberOfAttempts());
    }

    private List<String> resolveWinner(RacingGameRq racingGameRq) {
        return viewResolver.winners(racingGameRq.getRacingCarDtoList());
    }
}
