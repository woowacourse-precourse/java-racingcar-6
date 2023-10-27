package util;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingCarInputReader implements InputReader{
    public List<String> inputPlayers() throws IllegalArgumentException{
        List<String> players =  List.of(Console.readLine().split(","));
        if(!isInputPlayerValid(players)){
            throw new IllegalArgumentException();
        }
        return players;
    }

    public boolean isInputPlayerValid(List<String> players){
        if(players.isEmpty()){
            return false;
        }
        return players.stream().allMatch(player -> player.length() <= 5);
    }
}
