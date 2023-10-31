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
        gameSet();
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

    private void gameSet() {
        OutputView.gameSetView();
        List<String> winnerList = findWinner(roundResultList.get(round - 1));
        for (int i = 0; i < round; i++) {
            OutputView.roundConditionView(roundResultList.get(i));
        }
    }

    public List<String> findWinner(List<Result> resultList) {
        List<String> winnerList = new ArrayList<>();
        int maxValue = -1;

        for (Result result : resultList) {
            maxValue = addWinner(winnerList, result, maxValue);
        }

        return winnerList;
    }

    private int addWinner(List<String> winnerList, Result result, int maxValue) {
        int newMaxValue = maxValue;
        if (result.getDistance() > newMaxValue) {
            winnerList.clear();
            newMaxValue = result.getDistance();
            winnerList.add(result.getCarName());
        } else if (result.getDistance() == maxValue) {
            winnerList.add(result.getCarName());
        }
        return newMaxValue;
    }
}
