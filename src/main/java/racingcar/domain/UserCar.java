package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import racingcar.controller.UserCarService;
import racingcar.view.InputView;

public class UserCar {
    public Map<String, Integer> car;
    public int roundNumber;
    private UserCarService userCarService = new UserCarService();

    public UserCar(){
        inputCarName();
    }
    public void inputCarName(){
        Map<String, Integer> resource = InputView.inputCarNameView();
        if(userCarService.checkCorrectName(resource)){
            this.car = resource;
        };
    }

}

