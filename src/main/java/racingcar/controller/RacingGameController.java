package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.CarNameList;

public class RacingGameController {
    private static CarNameList carNameList;
    public void init(){
        carNameList = CarNameList.getinstance(InputCarString());
        carNameList.PrintCarName();
    }
    public String[] InputCarString(){
        String carName = Console.readLine();
        return carName.split(",");
    }
}
