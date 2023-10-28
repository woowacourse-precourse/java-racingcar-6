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
    public boolean go(int num){
        if(num>=4)return true;
        else return false;
    }
}
