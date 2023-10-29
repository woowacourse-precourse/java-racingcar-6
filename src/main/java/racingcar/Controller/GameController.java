package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class GameController {
    private InputView inputView;
    private OutputView outputView;
    private List<Car> carList;
    private Validator validator;

    public GameController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carList = new ArrayList<>();
        this.validator = new Validator();
    }

    public void runGame(){
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
    }

    private void fillCarList(List<String> carNameList){
        for(String carName : carNameList){
            validator.validCarName(carName);
            Car newCar = new Car(carName);
            carList.add(newCar);
        }
    }

    private void runRace(int raceCounts){
        for(int i = 0; i < raceCounts; i++){
            for(Car car : this.carList) {
                raceOnce(car);
            }
            //고민 사항 매회 추가하는 개행을 OutputView에서 처리할지?
            System.out.println();
        }
    }
    private void raceOnce(Car car){
        if(getRandomNumber() >= 4){
            car.addProgress();
        }
        this.outputView.printRaceProgress(car);
    }

    private int getRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }
}
