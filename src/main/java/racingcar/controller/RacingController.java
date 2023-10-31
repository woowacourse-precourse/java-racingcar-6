package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Computer;
import racingcar.domain.Emcee;
import racingcar.domain.RandomNumber;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.CarNameInput;
import racingcar.view.RacingViewer;
import racingcar.view.TryCountInput;

import java.util.HashMap;
import java.util.Map;

public class RacingController {

    private final static Car car = new Car();
    private final static Computer computer = new Computer();
    private final static Emcee emcee = new Emcee();
    private final static RandomNumber randomNumber = new RandomNumber();
    private final static CarNameValidator carNameValidator = new CarNameValidator();
    private final static TryCountValidator tryCountValidator = new TryCountValidator();
    private final static CarNameInput carNameInput = new CarNameInput();
    private final static TryCountInput tryCountInput = new TryCountInput();
    private final static RacingViewer racingViewer = new RacingViewer();

    public void run() {
        racingViewer.showCarNameMessage();
        Map<String, Integer> carList = new HashMap<>();
        setCarList(carList);

        int tryCount = getTryCount();

        racingViewer.showResultMessage();
        startRace(carList, tryCount);
    }

    private void setCarList(Map<String, Integer> list) {
        for (String name : carNameInput.returnCarName()) {
            carNameValidator.checkCarNameLength(name);
            list.put(name, 0);
        }
        carNameValidator.checkDuplicatedCarName(list);
    }

    private int getTryCount() {
        racingViewer.showTryCountMessage();
        String tryCount = tryCountInput.returnTryCount();
        tryCountValidator.isNumber(tryCount);
        tryCountValidator.isNumberInRange(tryCount);

        return Integer.parseInt(tryCount);
    }

    private void startRace(Map<String, Integer> carList, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            tmpRace(carList);
            racingViewer.showNewLine();
        }
    }

    private void tmpRace(Map<String, Integer> carList) {
        for (String name : carList.keySet()) {
            doesCarMove(carList, name);
        }
    }

    private void doesCarMove(Map<String, Integer> carList, String name) {
        int random = randomNumber.createRandomNumber();

        if (computer.judgeCarMovement(random)) {
            car.move(carList.get(name));
        };
    }
}
