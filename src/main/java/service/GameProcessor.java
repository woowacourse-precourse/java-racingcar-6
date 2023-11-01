package service;

import camp.nextstep.edu.missionutils.Console;
import model.CarList;

public class GameProcessor {

    private final ProcessHelper processHelper = new ProcessHelper();
    private final Validation validation = new Validation();
    public CarList namingCar(){
        String[] carNameArray = processHelper.commaSeperate(Console.readLine());
        return processHelper.makeCarList(carNameArray);
    }

    public int setRound(){
        String roundInput = validation.roundInputValidation(Console.readLine());
        return Integer.parseInt(roundInput);
    }


}
