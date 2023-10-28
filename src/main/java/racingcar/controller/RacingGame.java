package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.CarName;
import racingcar.model.TryNumber;
import racingcar.model.RandomNumber;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    CarName carName;
    TryNumber tryNumber;
    RandomNumber randomNumber;
    Winner winner;
    private int[] ranking;
    private int tryNum;
    private ArrayList<String> cars = new ArrayList<>();
    private ArrayList<String> winnerList = new ArrayList<>();


    public RacingGame(){
        carName = new CarName();
        tryNumber = new TryNumber();
        randomNumber = new RandomNumber();
        winner = new Winner();
    }
    public void start(){
        InputCarNames();//자동차 이름 입력, 정리 다 됨.
        getTryNumber();//시도 횟수 입력
        onRacing(cars,tryNum);
        setWinner(ranking, cars);

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
        ranking = new int[cars.size()];
        for(int i = 0; i < tryNumber; i++){
            isForwarding(cars);
            outputView.printCurrentRanking(getCurrentRanking(),cars);

        }
    }
    public void setWinner(int[] ranking, ArrayList<String> cars){
        winner.decideWinner(ranking, cars);
        outputView.printWinner(winner.getWinnerList());
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
         //onRacing에서 호출 될때마다 ranking 초기화 되는 문제 해결-> static으로 지정-> 정수배열 포기
        for(int i = 0; i < cars.size(); i++){
            if(isGo()){
                ranking[i]++;
            }
        }
    }
}
