package racingcar.controller;

import java.util.List;
import java.util.Map;
import racingcar.model.converter.inputConverter.InputConverter;
import racingcar.model.data.Cars;
import racingcar.model.data.Race;
import racingcar.model.generator.MovementGenerator;
import racingcar.model.record.MoveCount;
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
        race = new Race(new Cars(Cars.FromNames(carNamesFromUsers)), new MoveCount(moveCountFromUsers));
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

    public void startRace(MovementGenerator movementGenerator) {
        List<Map<String, Integer>> result = race.startMove(movementGenerator);
        raceView.displayRaceStatus(result);
    }
    public void endRace() {}
}