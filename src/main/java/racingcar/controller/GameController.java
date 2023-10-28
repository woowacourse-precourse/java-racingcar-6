package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.RacingCar;
import racingcar.validator.InputValidation;
import racingcar.view.*;

public class GameController {
    OutputView getMessage = new OutputView();
    InputView putMessage = new InputView();
    GameUtils gameUtility = new GameUtils();
    InputValidation validator = new InputValidation();

    List<RacingCar> racingCarList = new ArrayList<>();  // 추후 일급 컬랙션 적용 해보기

    public void run() {
        getMessage.GameStartMessage();
        String namesOfRacingCars = putMessage.getPlayerInput();
        if (validator.checkPlayerInput(namesOfRacingCars)) {    // 일급 컬랙션 적용하면 예외처리부도 뗄 수 있음
            List<String> carNameList = gameUtility.splitByComma(namesOfRacingCars);
            addRacingCar(carNameList);
        } else {
            throw new IllegalArgumentException();
        }
    }
    public void addRacingCar(List<String> racingCarList){   // util에 있는게 좀 더 어울릴듯
        for (String carName : racingCarList) {
            this.racingCarList.add(new RacingCar(carName));
        }
    }
}
