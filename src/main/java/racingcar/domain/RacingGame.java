package racingcar.domain;

import racingcar.ValidChecker;
import racingcar.View.OutputView;
import racingcar.View.InputView;

import java.util.List;

public class RacingGame {

    private final String SEPARATOR = ",";
    private final String ESCAPE_GAME = "[ERROR] 잘못된 입력으로 프로그램을 종료합니다.";

    private ValidChecker validChecker = new ValidChecker();
    private static List<Car> carList = Car.carList;

    public void start() {
        String[] cars = askCarName();
        int trialNum = askTrialNumber();
        makeCarList(cars);
        printDistance(carList, trialNum);
        Car.getWinner();
    }

    public void printDistance(List<Car> carList, int trialNum) {
        OutputView.printGameResult();
        for (int i = 0; i < trialNum; i++) {
            for (Car car : carList) {
                Car.canMove(car);
                OutputView.printPlayerAndPosition(car);
            }
            System.out.println();
        }
    }

    private void makeCarList(String[] cars) {
        for (String name : cars) {
            Car car = new Car(name, 0);
            car.addCarList(car);
        }
    }

    private String[] askCarName() {
        String inputCars = InputView.getCarNameList();
        boolean result = validChecker.isValidCar(inputCars);
        if (!result) {
            throw new IllegalArgumentException(ESCAPE_GAME);
        }
        return inputCars.split(SEPARATOR);
    }

    private int askTrialNumber() {
        String inputTrialNum = InputView.getAskNumberOfAttempts();
        boolean result = validChecker.isValidNum(inputTrialNum);
        if (!result) {
            throw new IllegalArgumentException(ESCAPE_GAME);
        }
        return Integer.parseInt(inputTrialNum);
    }
}
