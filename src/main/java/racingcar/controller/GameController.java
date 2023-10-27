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
        if (validator.checkPlayerInput(namesOfRacingCars)) {
            List<String> carNameList = gameUtility.splitByComma(namesOfRacingCars);
            for (String carName : carNameList) {
                racingCarList.add(new RacingCar(carName));
            }

        } else {
            throw new IllegalArgumentException();
        }
    }
}
