package racingcar.controller;

import racingcar.model.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarGameController {
    private CarName carName = new CarName();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private GameRunCnt runCnt = new GameRunCnt();
    private RacingCars racingCars;

    public CarGameController(){
        startGame();
        outputView.gameResultMessage();
        for(int i=0; i<runCnt.getRunNumber(); i++){
            playGame();
        }
        endGame();
    }
    public void startGame(){
        carName.setCarName(inputView.inputCarName());
        racingCars = new RacingCars(carName.getCarName());
        runCnt.gameRunNumber(inputView.inputGameNumber());

    }
    public void playGame(){
        List<String> strList = new ArrayList<>();
        for(int i=0; i<racingCars.size(); i++) {
            RandomNumber randomNumber = new RandomNumber();
            Car car = racingCars.getCar(i);
            if(go(randomNumber.getRandomNumber())){
                car.score();
            }
            String str = car.getName() + " : ";
            for(int j=0; j<car.getScore(); j++){
                str+="-";
            }
            str+="\n";
            strList.add(str);
        }
        outputView.gameResultStatus(strList);
    }
    public void endGame(){
        String winner = winner();
        outputView.gameWinner(winner);
    }
    public boolean go(int num){
        if(num>=4)return true;
        else return false;
    }
    public String winner(){
        int max=0;
        String winner="";
        for(Car car : racingCars.getCarList()){
            if(car.getScore()>max){
                max = car.getScore();
                winner=car.getName();
            }
            else if(car.getScore()==max){
                winner+=", " + car.getName();
            }
        }
        return winner;
    }
}
