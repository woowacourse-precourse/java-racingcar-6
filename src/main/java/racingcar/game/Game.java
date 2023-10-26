package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
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

    private List<Player> getChampions( List<Player> players ){
        List<Player> champions = new ArrayList<>();

        if(players.size()==1){
            return players;
        }

        Collections.sort(players,
            (e1, e2)->{
                return e2.getDistance()-e1.getDistance();
            }
        );

        champions.add(players.get(0));

        for(int i = 1 ; i<players.size(); i++){
            if(players.get(i).getDistance() == champions.get(0).getDistance()){
                champions.add(players.get(i));
            }
        }

        return champions;
    }
}
