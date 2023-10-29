package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private Integer tryCount;

    private Cars cars;

    public void run() {
        initCars();
        this.tryCount = InputView.inputTryCount();
        System.out.println("실행 결과\n");
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

    private boolean isTryCountRemain() {
        return this.tryCount > 0;
    }

    private void minusTryCount() {
        this.tryCount --;
    }

}
