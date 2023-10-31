package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import racingcar.view.InputView;

public class UserCar {
    private Map<String, Integer> car;
    public UserCar(){
    }

    public void inputCarName(){
        this.car = InputView.inputCarNameView();
        System.out.println(car);
    }
}

