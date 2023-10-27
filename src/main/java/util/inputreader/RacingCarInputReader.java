package util.inputreader;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingCarInputReader implements InputReader {
    public List<String> inputPlayers() throws IllegalArgumentException{
        List<String> players =  List.of(Console.readLine().split(","));
        if(!isInputPlayerValid(players)){
            throw new IllegalArgumentException("Invalid player names");
        }
        return players;
    }

    public boolean isInputPlayerValid(List<String> players){
        if(players.isEmpty()){
            return false;
        }
        return players.stream().allMatch(player -> player.length() <= 5);
    }

    public int inputTryCount() throws IllegalArgumentException{
        int tryCount = Integer.parseInt(Console.readLine());
        if(!isInputTryCountValid(tryCount)){
            throw new IllegalArgumentException("Invalid try count");
        }
        return tryCount;
    }

    public boolean isInputTryCountValid(int tryCount){
        return tryCount > 0;
    }
}
