package racingcar.controller;

import racingcar.dto.input.NumberOfAttemptsDto;
import racingcar.dto.input.RacingCarsDto;
import racingcar.dto.output.ResultOfGameDto;
import racingcar.dto.output.ResultOfTurnDto;
import racingcar.model.RacingCars;
import racingcar.view.RacingGameView;

import java.util.List;


public class RacingGameController {
    private final RacingGameView racingGameView;

    public RacingGameController(RacingGameView racingGameView) {
        this.racingGameView = racingGameView;
    }
    public void startRacing() {
        RacingCarsDto racingCarsDto = racingGameView.inputCarName();
        NumberOfAttemptsDto numberOfAttemptsDto = racingGameView.inputNumberOfAttempts();
        playRacing(racingCarsDto, numberOfAttemptsDto);
    }
    private void playRacing(RacingCarsDto racingCarsDto, NumberOfAttemptsDto numberOfAttemptsDto) {
        racingGameView.printResultMessage();
        RacingCars racingCars = racingCarsDto.toRacingCars();
        for (int i = 0; i < numberOfAttemptsDto.toInteger(); i++) {
            List<ResultOfTurnDto> totalResult = racingCars.getTotalResultOfTurn();
            racingGameView.showAdvancecProgressOfTurn(totalResult);
        }
        ResultOfGameDto winners = racingCars.getWinners();
        racingGameView.showWinners(winners);
    }
}
