package racingcar.controller;

import racingcar.model.race.Race;
import racingcar.model.validator.CarNameValidator;
import racingcar.model.validator.MovingCountValidator;
import racingcar.view.UserInputValue;

public class RaceController {
    CarNameValidator carNameValidator = new CarNameValidator();
    MovingCountValidator movingCountValidator = new MovingCountValidator();
    private int countNum;

    public RaceController() {
    }

    public void startRace() {
        String[] carNames = validateInput();
        Race race = printTrack(carNames);
        runRace(race);
        printResult(race);
    }

    private String[] validateInput() {
        String carName = UserInputValue.inputCarName();
        String[] carNames = carNameValidator.changeArrayType(carName);
        carNameValidator.checkNameValidation(carNames);
        String count = UserInputValue.inputMovementCount();
        countNum = Integer.parseInt(count);
        movingCountValidator.checkMovementCount(count);
        return carNames;
    }

    private Race printTrack(String[] carNames) {
        System.out.println();
        System.out.println("실행 결과");
        return new Race(carNames);
    }

    private void runRace(Race race) {
        for (int i = 0; i < countNum; i++) {
            race.printRace();
        }
    }

    private void printResult(Race race) {
        race.selectWinner();
    }
}
