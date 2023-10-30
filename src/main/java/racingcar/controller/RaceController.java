package racingcar.controller;

import racingcar.model.data.Race;
import racingcar.model.generator.MovementGenerator;
import racingcar.model.validator.carName.CarNameValidator;
import racingcar.view.RaceView;

public class RaceController {
    private Race race;
    private RaceView raceView;


    public RaceController(RaceView raceView) {
        this.raceView = raceView;
    }

    public void initGame(CarNameValidator carNameValidator) {
        raceView.displayCarNameInputNotice();
        String[] carNamesFromUsers = raceView.getCarNamesFromUsers();
        carNameValidator.validateAll(carNamesFromUsers);
    }

    public void initRace(MovementGenerator movementGenerator) {

    }
    public void startRace() {}
    public void endRace() {}
}
