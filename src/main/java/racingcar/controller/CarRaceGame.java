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
    private List<Car> carImplList = new ArrayList<Car>();

    public CarRaceGame() {
    }

    public void run() {
        startGame();
    }

    public void startGame() {
        String carNames = CarRaceGameView.startGameView();
        setUpCar(carNames);

        String attemptNumberString = CarRaceGameView.attemptNumberView();
        setUpGameManager(attemptNumberString);

        carRaceGameUtility = CarRaceGameUtility.create(gameManager, carImplList);
        carRaceGameUtility.startCarRaceGame();
    }

    private void setUpCar(String carNames) {
        List<String> carNameList = CarNamesToList(carNames);
        for (String carName : carNameList) {
            Validator.carNameStringLength(carName);
            Validator.isSpace(carName);
            carImplList.add(new Car(carName));
        }
    }

    private List<String> CarNamesToList(String carNames) {

        return Arrays.stream(carNames.split(",")).toList();
    }

    private void setUpGameManager(String attemptNumberString) {
        gameManager = GameManager.create(Integer.parseInt(attemptNumberString), carImplList);
    }
}
