package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public class PlayNumber {

    public int validatedUserInput(){
        String userInput = Console.readLine();
        return valid(userInput);
    }

    public int valid(String userInput) throws IllegalArgumentException{
        int playNum = notNumber(userInput);
        if(playNum == 0){
            throw new IllegalArgumentException();
        }
        return playNum;
    }

    public int notNumber(String userInput) throws IllegalArgumentException{
        try{
            return Integer.parseInt(userInput);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }



}
