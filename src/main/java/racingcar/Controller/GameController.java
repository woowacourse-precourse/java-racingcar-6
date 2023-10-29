package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GameController {
    private InputView inputView;
    private OutputView outputView;
    private List<Car> carList;
    private Validator validator;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carList = new ArrayList<>();
        this.validator = new Validator();
    }

    public void runGame() {
        String tryCount;
        int validCountNum;
        // 경주할 자동차 이름에 대한 입력
        List<String> carNameList = new ArrayList<>(Arrays.asList(this.inputView.inputCarNames()));
        validator.validListIsEmpty(carNameList);
        fillCarList(carNameList);
        // 시도할 횟수에 대한 입력
        tryCount = this.inputView.inputCounts();
        validCountNum = validator.getValidNumber(tryCount);
        // 실행 결과
        this.outputView.printResultInit();
        runRace(validCountNum);
        // 우승자 선정
        this.outputView.printFinalWinners(checkWinner());

    }

    private void fillCarList(List<String> carNameList) {
        for (String carName : carNameList) {
            validator.validCarName(carName);
            Car newCar = new Car(carName);
            carList.add(newCar);
        }
    }

    private void runRace(int raceCounts) {
        for (int i = 0; i < raceCounts; i++) {
            for (Car car : this.carList) {
                raceOnce(car);
            }
            // 고민 사항 : 매회 추가하는 개행을 OutputView에서 처리할지?
            System.out.println();
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

    private Queue<String> checkWinner(){
        int max = 0;
        Queue<String> winners = new LinkedList<>();
        for (Car car : this.carList){
            int progressCounter = car.getProgressCounter();
            if (max < progressCounter){
                // 새로운 최대 진행 카운터를 찾았으므로 이전 우승자를 모두 제거하고 새로운 우승자를 추가
                winners.clear();
                max = progressCounter;
                winners.add(car.getCarName());
            } else if (max == car.getProgressCounter()){
                // 현재 우승자와 동일한 진행 카운터를 가진 차량을 추가
                winners.add(car.getCarName());
            }
        }
        return winners;
    }
}
