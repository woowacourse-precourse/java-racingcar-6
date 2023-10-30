package racingcar.controller;

import racingcar.model.race.Race;
import racingcar.model.validator.CarNameValidator;
import racingcar.model.validator.MovingCountValidator;
import racingcar.view.UserInputValue;

public class RaceController {
    CarNameValidator carNameValidator = new CarNameValidator();
    MovingCountValidator movingCountValidator = new MovingCountValidator();
    private int countNum; // countNum 변수를 runRace 반복문에서 써먹어야됨

    public RaceController() {
    }

    public void startRace() {
        String[] carNames = validateInput();
        Race race = printTrack(carNames);
        runRace(race); // countNum을 사용할 수 있도록 runRaces 메소드로 전달
        printResult(race);
    }

    private String[] validateInput() {
        String carName = UserInputValue.inputCarName();
        String[] carNames = carNameValidator.changeArrayType(carName);
        carNameValidator.checkNameValidation(carNames);
        String count = UserInputValue.inputMovementCount();
        countNum = Integer.parseInt(count); // countNum 변수에 할당
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
