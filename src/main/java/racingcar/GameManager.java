package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
public class GameManager {
    private List<Player> players;
    private int maxCount;
    private String winner;

    GameManager(){
        gameInit(0);
    }
    GameManager(int maxCount){
        gameInit(maxCount);
    }
    public int getMaxCount(){
        return maxCount;
    }
    public void setMaxCount(int maxCount){
        this.maxCount = maxCount;
    }
    public String getWinner(){
        return winner;
    }
    public void setWinner(String winner){
        this.winner = winner;
    }
    private void gameInit(int maxCount){
        setMaxCount(maxCount);
        setWinner("");
    }

    public void setPlayers() {
        StringTokenizer st = new StringTokenizer(Console.readLine(),",");
        while(st.hasMoreTokens()){
            addPlayer(st.nextToken());
        }
    }
    public void addPlayer(String name){
        players.add(new Player(name));
    }

    public void play(){
        players.forEach( player -> {
            player.move();
            player.print();
        });
    }

    public void findWinner(){
        Collections.sort(players);
        setWinner(players.get(0).getName());
        int maxNum = players.get(0).getCount();
        for(int i=1;i<players.size();i++)
        {
            Player player = players.get(i);
            if(player.getCount()<maxNum) {
                return;
            }
            setWinner(getWinner()+" , "+player.getName());
        }
    }

    public void print(){
        System.out.println("최종우승자 : "+getWinner());
    }
}
