package racingcar.controller;

import racingcar.dto.input.NumberOfAttemptsDto;
import racingcar.dto.input.RacingCarsDto;
import racingcar.dto.output.ResultOfGameDto;
import racingcar.dto.output.ResultOfTurnDto;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.view.RacingGameView;

import static racingcar.dto.output.ResultOfTurnDto.createAdvancecProgress;

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
            runRaceTurn(racingCars);
        }
        ResultOfGameDto winners = racingCars.getWinners();
        racingGameView.showWinners(winners);
    }
    private void runRaceTurn(final RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getRacingCars()) {  // getter 안쓸수 있는 방향으로 리팩토
            if (racingCar.canAdvance()) {
                racingCar.advance();
            }
            ResultOfTurnDto resultOfTurnDto = createAdvancecProgress(racingCar);
            racingGameView.showAdvancecProgress(resultOfTurnDto);
        }
        racingGameView.printSpaceLine();
    }
}
