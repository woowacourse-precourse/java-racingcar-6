package racingcar.controller;

import racingcar.model.converter.inputConverter.InputConverter;
import racingcar.model.data.Race;
import racingcar.model.validator.carName.CarNameValidator;
import racingcar.model.validator.moveCount.MoveCountValidator;
import racingcar.view.RaceView;

public class RaceController {
    private Race race;
    private RaceView raceView;


    public RaceController(RaceView raceView) {
        this.raceView = raceView;
    }

    public void initRace(CarNameValidator carNameValidator, InputConverter<Long> inputConverter, MoveCountValidator moveCountValidator) {
        String[] carNamesFromUsers = getCars(carNameValidator);
        int moveCountFromUsers = getMoveCount(inputConverter, moveCountValidator);
    }

    private String[] getCars(CarNameValidator carNameValidator) {
        raceView.displayCarNameInputNotice();
        String[] carNamesFromUsers = raceView.getCarNamesFromUsers();
        carNameValidator.validateAll(carNamesFromUsers);

        return carNamesFromUsers;
    }

    private int getMoveCount(InputConverter<Long> inputConverter, MoveCountValidator moveCountValidator) {
        raceView.displayMoveCountInputNotice();
        String input = raceView.getMoveCountFromUsers();
        Long moveCountFromUsers = inputConverter.convertToType(input);
        moveCountValidator.validateAll(moveCountFromUsers);

        return moveCountFromUsers.intValue();
    }
    public void startRace() {}
    public void endRace() {}
}