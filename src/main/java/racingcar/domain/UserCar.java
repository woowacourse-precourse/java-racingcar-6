package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import racingcar.controller.UserCarService;
import racingcar.view.InputView;

public class UserCar {
    public Map<String, Integer> car;
    private UserCarService userCarService = new UserCarService();
    public UserCar(){
    }
    public UserCar(Map<String, Integer> resource){
        this.car = resource;
    }
}

