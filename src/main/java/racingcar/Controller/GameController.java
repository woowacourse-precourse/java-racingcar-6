package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class GameController {
    private InputView inputView;
    private OutputView outputView;
    private List<Car> carList;
    private Validator validator;
    private int validCountNum;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carList = new ArrayList<>();
        this.validator = new Validator();
    }

    public void runGame() {
        // 경주할 자동차 이름에 대한 입력
        List<String> carNameList = new ArrayList<>(Arrays.asList(this.inputView.inputCarNames()));
        fillCarList(carNameList);
        // 시도할 횟수에 대한 입력
        this.validCountNum = getValidNumber(this.inputView.inputCounts());
        validator.limitPrint(this.validCountNum, carNameList.size());
        // 실행 결과
        runRace(this.validCountNum);
        // 우승자 선정
        this.outputView.printFinalWinners(determineWinners());
    }

    private void fillCarList(List<String> carNameList) {
        validator.validListIsEmpty(carNameList);
        for (String carName : carNameList) {
            validator.validCarName(carName);
            Car newCar = new Car(carName);
            carList.add(newCar);
        }
    }

    private void runRace(int raceCounts) {
        this.outputView.printResultInit();
        for (int i = 0; i < raceCounts; i++) {
            for (Car car : this.carList) {
                raceOnce(car);
            }
            outputView.printNewLine();
        }
    }

    private void raceOnce(Car car) {
        if (getRandomNumber() >= 4) {
            car.addProgress();
        }
        this.outputView.printRaceProgress(car);
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private int getValidNumber(String inputNum) {
        return validator.validNumber(inputNum);
    }

    private List<String> determineWinners() {
        int max = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : this.carList) {
            int progressCounter = car.getProgressCounter();
            if (max < progressCounter) {
                // 새로운 최대 진행 카운터를 찾았으므로 이전 우승자를 모두 제거하고 새로운 우승자를 추가
                winners.clear();
                max = progressCounter;
                winners.add(car.getCarName());
            } else if (max == car.getProgressCounter()) {
                // 현재 우승자와 동일한 진행 카운터를 가진 차량을 추가
                winners.add(car.getCarName());
            }
        }
        return winners;
    }
}
