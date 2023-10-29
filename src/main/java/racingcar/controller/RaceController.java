package racingcar.controller;

import racingcar.model.Race;
import racingcar.model.validator.CarNameValidator;
import racingcar.model.validator.MovingCountValidator;
import racingcar.model.RaceTrack;
import racingcar.view.UserInputValue;

public class RaceController {

    CarNameValidator carNameValidator = new CarNameValidator();
    MovingCountValidator movingCountValidator = new MovingCountValidator();

    public RaceController() {
    }

    public void startRace() {
        String carName = UserInputValue.inputCarName();
        String[] carNames = carNameValidator.changeArrayType(carName);
        carNameValidator.checkNameValidation(carNames);
        String count = UserInputValue.inputMovementCount();
        int countNum = Integer.parseInt(count);
        movingCountValidator.checkMovementCount(count);

        System.out.println();
        System.out.println("실행 결과");

        Race race = new Race(carNames);

        for (int i = 0; i < countNum; i++) {
            race.printRace();
        }
    }


}

//package racingcar.controller;

//
//import racingcar.model.validator.CarNameValidator;
//import racingcar.model.validator.MovingCountValidator;
//import racingcar.model.RaceTrack;
//import racingcar.view.UserInputValue;
//
//public class RaceController {
//
//    CarNameValidator carNameValidator = new CarNameValidator();
//    MovingCountValidator movingCountValidator = new MovingCountValidator();
//
//    public RaceController() {
//    }
//
//    public void startRace() {
//        String carName = UserInputValue.inputCarName();
//        String[] carNames = carNameValidator.changeArrayType(carName);
//        carNameValidator.checkNameValidation(carNames);
//        String count = UserInputValue.inputMovementCount();
//        int countNum = Integer.parseInt(count);
//        movingCountValidator.checkMovementCount(count);
//
//        System.out.println();
//        System.out.println("실행 결과");
//
//        RaceTrack raceTrack = new RaceTrack(carNames);
//        raceTrack.printCarNames();
//        raceTrack.race(countNum);
//
//        raceTrack.endRace();
//    }
//}
