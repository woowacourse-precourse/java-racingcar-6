package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public class NumberOfPlay {

    public int validatedUserInput(){
        String userInput = Console.readLine();
        return valid(userInput);
    }

    public int valid(String userInput) throws IllegalArgumentException{
        int playCount = notNumber(userInput);
        if(playCount == 0){
            throw new IllegalArgumentException();
        }
        return playCount;
    }

    public int notNumber(String userInput) throws IllegalArgumentException{
        try{
            return Integer.parseInt(userInput);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }



}
