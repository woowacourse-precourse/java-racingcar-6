package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Computer;
import racingcar.domain.Emcee;
import racingcar.domain.RandomNumber;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.CarNameInput;
import racingcar.view.RacingViewer;
import racingcar.view.TryCountInput;

import java.awt.*;

public class RacingController {

    private final static Computer computer = new Computer();
    private final Emcee emcee = new Emcee();
    private final RandomNumber randomNumber = new RandomNumber();
    private final CarNameValidator carNameValidator = new CarNameValidator();
    private final TryCountValidator tryCountValidator = new TryCountValidator();
    private final CarNameInput carNameInput = new CarNameInput();
    private final TryCountInput tryCountInput = new TryCountInput();
    private final RacingViewer racingViewer = new RacingViewer();

    public void run() {

    }
}
