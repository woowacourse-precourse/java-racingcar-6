package racingcar.controller;

import static racingcar.constant.GameConstants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.constant.GameConstants;
import racingcar.domain.Car;
import racingcar.domain.GameManager;
import racingcar.utility.CarRaceGameUtility;
import racingcar.validator.Validator;
import racingcar.view.CarRaceGameView;

public class CarRaceGame {
    private GameManager gameManager;
    private CarRaceGameUtility carRaceGameUtility;

    public CarRaceGame() {
    }

    public void run() {
        startGame();
    }

    public void startGame() {
        String carNames = CarRaceGameView.startGameView();
        List<Car> carImplList = setUpCar(carNames);

        String attemptNumberString = CarRaceGameView.attemptNumberView();

        gameManager = GameManager.create(Integer.parseInt(attemptNumberString), carImplList);

        carRaceGameUtility = CarRaceGameUtility.create(gameManager);
        carRaceGameUtility.startCarRaceGame();
    }

    private List<Car> setUpCar(String carNames) {
        List<String> carNameList = CarNamesToList(carNames);
        List<Car> carImplList = new ArrayList<Car>();

        for (String carName : carNameList) {
            Validator.carNameStringLength(carName);
            Validator.isSpace(carName);
            carImplList.add(new Car(carName));
        }
        return carImplList;
    }

    private List<String> CarNamesToList(String carNames) {

        return Arrays.stream(carNames.split(",")).toList();
    }


}
