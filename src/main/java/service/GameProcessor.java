package service;

import camp.nextstep.edu.missionutils.Console;
import model.Message;
import service.ProcessHelper;

public class GameProcessor {

    private final ProcessHelper processHelper = new ProcessHelper();

    public void namingCar(){

        System.out.println(Message.GAMESTART);
        
    }

    public void setRound(){
        Console.readLine();
    }


}
