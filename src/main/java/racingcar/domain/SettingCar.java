package racingcar.domain;

import java.util.HashMap;

import racingcar.view.InputView;

public class SettingCar {
    InputView inputView = new InputView();
    CreateCarList createCarList = new CreateCarList();
    public HashMap<String, Integer> settingCar(){
        return createCarList.createCarNameList(inputView.carNameInput());
    }

}
