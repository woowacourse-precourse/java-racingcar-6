package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players;
    public void run(){

    }

    private List<Player> setPlayers(String userNames){
        if(userNames.isEmpty()){
            throw new IllegalArgumentException();
        }

        String[] users = userNames.split(",");

        if(users.length==0){
            throw new IllegalArgumentException();
        }

        List<Player> playerList = new ArrayList<>();

        for(String user : users){
            if(checkNameLength(user)){
                playerList.add(new Player(user));
            }else {
                throw new IllegalArgumentException();
            }
        }

        return playerList;
    }

    private boolean checkNameLength(String name){
        String removeSpace = name.trim();
        if(removeSpace.length()<=5 && removeSpace.length()>=1){
            return true;
        }
        return false;
    }

    private boolean isForward(){
        if(Randoms.pickNumberInRange(0,9) < 4){
            return false;
        };
        return true;
    }
}
