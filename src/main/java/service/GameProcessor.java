package service;

import camp.nextstep.edu.missionutils.Console;
import model.CarList;
import model.Message;
import service.ProcessHelper;

public class GameProcessor {

    private final ProcessHelper processHelper = new ProcessHelper();

    public void namingCar(){

        System.out.println(Message.GAMESTART);

        String[] carNameArray = processHelper.commaSeperate(Console.readLine());

        CarList carList = processHelper.makeCarList(carNameArray);


    }

    public void setRound(){
        Console.readLine();
    }


}
