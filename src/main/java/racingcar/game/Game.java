package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private List<Player> players;
    private Message message = new Message();
    public void run(){
        System.out.println(message.requestPlayerName);
        String userNames = Console.readLine();
        players = setPlayers(userNames);

        System.out.println(message.requestPlayCount);
        String countString = Console.readLine();
        if(!isInteger(countString)){
            throw new IllegalArgumentException();
        }

        System.out.println(message.result);

        int count = Integer.parseInt(countString);

        for (int i = 0 ; i<count; i++){
            for (int j = 0 ; j<players.size(); j++){
                Player player = players.get(j);
                isForward(player);
                System.out.println(message.distanceOfPlayer(player));
            }
            System.out.println();
        }

        System.out.println(message.champions(getChampions(players)));
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
            String removeSpace = user.trim();
            if(checkNameLength(removeSpace)){
                playerList.add(new Player(removeSpace));
            }else {
                throw new IllegalArgumentException();
            }
        }

        return playerList;
    }

    private boolean checkNameLength(String name){
        if(name.length()<=5 && name.length()>=1){
            return true;
        }
        return false;
    }

    private void isForward(Player player){
        if(Randoms.pickNumberInRange(0,9) >= 4){
            player.forward();
        };
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

    private boolean isInteger(String count){
        try{
            Integer.parseInt(count);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
