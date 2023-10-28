package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.CarName;
import racingcar.model.TryNumber;
import racingcar.model.RandomNumber;
import racingcar.view.InputView;

public class RacingGame {
    InputView inputView = new InputView();
    CarName carName;
    TryNumber tryNumber;
    RandomNumber randomNumber;
    private int[] ranking;
    private int tryNum;
    private ArrayList<String> cars = new ArrayList<>();

    public RacingGame(){
        carName = new CarName();
        tryNumber = new TryNumber();
        randomNumber = new RandomNumber();
    }
    public void start(){
        InputCarNames();//자동차 이름 입력, 정리 다 됨.
        getTryNumber();//시도 횟수 입력
        onRacing(cars,tryNum);



    }
    public void InputCarNames(){
        String inputCarNames = inputView.InputCarNames();
        carName.carNamesToList(inputCarNames);
        carName.setClearCarList();
        this.cars = carName.getClearCarList();
    }
    public void getTryNumber(){
        String tryNum = inputView.InputTryNumber();
        tryNumber.isNoDigits(tryNum);
        this.tryNum = Integer.parseInt(tryNum);
    }

    public int[] getCurrentRanking(){
        return ranking;
    }
    public void onRacing(ArrayList<String> cars, int tryNumber){
        for(int i = 0; i < tryNumber; i++){
            isForwarding(cars);

        }
    }
    public boolean isGo(){
        int go = 0;
        randomNumber.generateRandomNumber();
        go = randomNumber.getRandomNumber();
        if(go >= 4){
            return true;
        }
        return false;
    }
    public void isForwarding(ArrayList<String> cars){
        ranking = new int[cars.size()];
        for(int i = 0; i < cars.size(); i++){
            if(isGo()){
                ranking[i]++;
            }
        }
    }
}
