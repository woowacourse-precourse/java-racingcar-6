package controller;

import camp.nextstep.edu.missionutils.Console;

public class UserInputController{
    public String inputCarNames(){
        String carNames = Console.readLine();
        return carNames;
    }
//    int inputRaceCount(){
//        String userInput = Console.readLine();
//        int racingCount = Integer.parseInt(userInput);
//        return racingCount;
//    }
}