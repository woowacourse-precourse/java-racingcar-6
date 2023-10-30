package racingcar.controller;

import racingcar.model.converter.inputConverter.InputConverter;
import racingcar.model.data.Race;
import racingcar.model.generator.MovementGenerator;
import racingcar.model.validator.carName.CarNameValidator;
import racingcar.model.validator.moveCount.MoveCountValidator;
import racingcar.view.RaceView;

public class RaceController {
    private Race race;
    private RaceView raceView;


    public RaceController(RaceView raceView) {
        this.raceView = raceView;
    }

    public void initGame(CarNameValidator carNameValidator, InputConverter<Long> inputConverter, MoveCountValidator moveCountValidator) {
        raceView.displayCarNameInputNotice();
        String[] carNamesFromUsers = raceView.getCarNamesFromUsers();
        carNameValidator.validateAll(carNamesFromUsers);

        raceView.displayMoveCountInputNotice();
        String input = raceView.getMoveCountFromUsers();
        Long moveCountFromUsers = inputConverter.convertToType(input);
        moveCountValidator.validateAll(moveCountFromUsers);
    }

    public void initRace(MovementGenerator movementGenerator) {

    }
    public void startRace() {}
    public void endRace() {}
}