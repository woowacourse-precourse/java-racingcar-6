package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {

    private List<Player> players;
    public void run(){

    }
/*
    private List<Player> setPlayers(){
        String input = Console.readLine();

        if(input.isEmpty()){
            throw new IllegalArgumentException();
        }

        String[] users = input.split(",");

    }
 */
    private boolean checkNameLength(String name){
        String removeSpace = name.trim();
        if(removeSpace.length()<=5 && removeSpace.length()>=1){
            return true;
        }
        return false;
    }
}
