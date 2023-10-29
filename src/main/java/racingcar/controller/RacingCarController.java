package racingcar.controller;

import racingcar.domain.dto.RunningCarDto;
import racingcar.domain.dto.WinnerDto;
import racingcar.domain.validator.CarNameValidator;
import racingcar.domain.validator.TryNumberValidator;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarNameValidator carNameValidator;
    private final TryNumberValidator tryNumberValidator;
    private final RacingCarService racingCarService;

    public RacingCarController(InputView inputView,
                               OutputView outputView,
                               CarNameValidator carNameValidator,
                               TryNumberValidator tryNumberValidator,
                               RacingCarService racingCarService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carNameValidator = carNameValidator;
        this.tryNumberValidator = tryNumberValidator;
        this.racingCarService = racingCarService;
    }

    public void inputCarNames() {
        String carNames = inputView.readCarNames();
        racingCarService.inputValidate(carNames, carNameValidator);
        racingCarService.insertCarNames(carNames);
    }

    public void inputTryNumber() {
        String tryNumber = inputView.readTryNumber();
        racingCarService.inputValidate(tryNumber, tryNumberValidator);
        racingCarService.insertTryNumber(tryNumber);
    }

    public void racingGameRun() {
        outputView.notifyResultRotate();

        do{
            List<RunningCarDto> racingStatus = racingCarService.rushCars();
            outputView.notifyCarRunning(racingStatus);
        } while(!racingCarService.isRaceOver());
    }

    public void outputWinner() {
        List<WinnerDto> winners = racingCarService.getWinner();
        outputView.notifyWinner(winners);
    }
}
