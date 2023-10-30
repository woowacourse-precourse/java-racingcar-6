package racingcar.controller;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.CarNameList;

public class RacingGameController {
    private static CarNameList carNameList;
    private static Integer tryNumber;
    public void init(){
        carNameList = CarNameList.getinstance(getCarString());
        carNameList.PrintCarName();
        tryNumber = getTryNumber();
    }
    public void progress(){

    }
    public String[] getCarString(){
        String carName = Console.readLine();
        return carName.split(",");
    }
    public Integer getTryNumber(){
        Integer inputNumber = parseInt(Console.readLine());
        return inputNumber;
    }
}
