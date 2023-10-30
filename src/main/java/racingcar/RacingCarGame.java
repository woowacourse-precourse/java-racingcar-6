package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private static final String TRY_RESULT = "실행 결과";
    private static final int MIN_TRY_COUNT = 0;
    private Integer tryCount;
    private Cars cars;

    public void run() {
        initCars();
        this.tryCount = InputView.inputTryCount();
        printTryResult();
        while (isTryCountRemain()) {
            playOneTry();
        }

        OutputView.outputWinnerRacingCarNames(cars);
    }

    public void initCars() {
        String[] carsNames = getCarNames();
        this.cars = makeCars(carsNames);
    }

    private void playOneTry() {
        cars.updateForwardCar();
        OutputView.outputRacingStatus(cars);
        minusTryCount();
    }

    private String[] getCarNames() {
        return Converter.splitCarNameWithComma(InputView.inputCarNames());
    }

    private Cars makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    private void printTryResult() {
        System.out.println(TRY_RESULT);
        System.out.println();
    }

    private boolean isTryCountRemain() {
        return this.tryCount > MIN_TRY_COUNT;
    }

    private void minusTryCount() {
        this.tryCount--;
    }

}
