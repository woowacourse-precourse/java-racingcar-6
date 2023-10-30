package racingcar.domain;

import java.util.Vector;

public class PlayerRepository {
    private Vector <Player> players = new Vector<>();

    public Vector<Player> getPlayers() {
        return players;
    }

    //player 추가 로직
    public void addPlayer(Player player){
        players.add(player);
    }

}
