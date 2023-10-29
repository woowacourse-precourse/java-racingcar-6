package racingcar.controller;

import static racingcar.constant.GameConstants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.constant.GameConstants;
import racingcar.domain.Car;
import racingcar.domain.GameManager;
import racingcar.validator.Validator;
import racingcar.view.CarRaceGameView;

public class CarRaceGame {
    private GameManager gameManager;
    private List<Car> carImplList = new ArrayList<Car>();

    public CarRaceGame() {
    }

    public void run() {
        startGame();
    }

    public void startGame() {
        String carNames = CarRaceGameView.startGameView();
        setUpCar(carNames);
        setUpGameManager();

        String attemptNumberString = CarRaceGameView.attemptNumberView();
        setUpAttemptNumber(attemptNumberString);

        startCarRaceGame();
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

    private void setUpGameManager() {
        gameManager = GameManager.create();
        gameManager.setCarQuantity(carImplList.size());
    }

    private void setUpAttemptNumber(String attemptNumberString) {
        gameManager.setAttemptNumber(Integer.parseInt(attemptNumberString));
    }

    public void startCarRaceGame() {
        System.out.println(EXECUTION_RESULT);

        for (int i = 0; i < gameManager.getAttemptNumber(); i++){
            startCarRaceGameOneRound();
        }
    }

    private void startCarRaceGameOneRound() {
        for (Car car : carImplList) {
            tryForward(car);
            CarRaceGameView.tryForwardResultView(car.getCarName(), car.getAdvanceNumber());
        }
        CarRaceGameView.LineBreakView();
    }

    private int randomNumberGenerator() {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
        return randomNumber;
    }

    private void tryForward(Car car) {
        if (4 >= randomNumberGenerator()) {
            car.setAdvanceNumber(car.getAdvanceNumber() + 1);
        }
    }

}
