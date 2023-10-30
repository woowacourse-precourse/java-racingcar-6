package racingcar.controller;

import java.util.HashMap;
import java.util.List;

import racingcar.domain.SettingNumber;
import racingcar.domain.SettingCar;
import racingcar.domain.CarMove;
import racingcar.view.OutputView;
import racingcar.domain.FindWinner;

public class GameController {
    SettingNumber settingNumber = new SettingNumber();
    SettingCar settingCar = new SettingCar();
    CarMove carMove = new CarMove();
    OutputView outputView = new OutputView();
    FindWinner findWinner = new FindWinner();

    public void run(){
        HashMap<String,Integer> carList = settingCar.settingCar();
        int setNumber = settingNumber.settingUserNumber();

        for(int i = 0; i < setNumber; i++){
            carMove.move(carList);
            outputView.printAllMove(carList);
        }

        List<String> winnerList = findWinner.findWinner(carList);
        outputView.printWinner(winnerList);
    }
}
