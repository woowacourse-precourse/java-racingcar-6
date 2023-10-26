package racingcar.input;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class PlayerName {

    public List<String> validatedUserInput(){
        String userInput = Console.readLine();
        return valid(userInput);
    }

    public List<String> valid(String userInput){
        String[] userInputSplit = userInput.split(",");
        List<String> players = Arrays.asList(userInputSplit);
        for(String player : players){
            notFiveOrLess(player);
        }
        return players;
    }

    public void notFiveOrLess(String player) throws IllegalArgumentException{
        if(player.length() > 5){
            throw new IllegalArgumentException();
        }
    }

}
