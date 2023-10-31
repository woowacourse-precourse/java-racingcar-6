package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;
import racingcar.validation.Validation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {
    private List<Car> carList;
    private int round;
    private List<List<Result>> roundResultList;

    public Race(){
        this.carList = new ArrayList<>();
        this.roundResultList = new ArrayList<>();
    }

    public void gameStart() {
        carsGeneration();
        roundGeneration();
    }

    public void carsGeneration() {
        OutputView.inputCarNameView();
        String[] carNames = InputView.inputCarName();
        for (var carName : carNames) {
            carAdd(carName);
        }
    }

    public void roundGeneration() {
        OutputView.inputTryNumberView();
        String tryNumber = InputView.inputTryNumber();
        this.round = setRound(tryNumber);
    }

    public int setRound(String tryNumber) {
        Validation.checkNatureNumber(tryNumber);
        return Integer.parseInt(tryNumber);
    }

    public void carAdd(String carName) {
        Validation.carNameSizeCheck(carName);
        carList.add(new Car(carName));
    }

    public void run() {
        gameStart();

        for (int i = 0; i < this.round; i++) {
            roundResultList.add(playRound());
        }
    }

    private List<Result> playRound() {
        List<Result> resultList = new ArrayList<>();
        for (Car car : carList) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            handleCar(car, randomValue);
            resultList.add(car.outputResult());
        }
        return resultList;
    }

    public void handleCar(Car car, int randomValue) {
        if (randomValue >= 4) {
            car.moveForward();
        }
    }
}
