package racingcar.domain;

import java.util.List;
import java.util.Vector;

public class PlayerRepository {
    private List<Player> players = new Vector<>();

    public List<Player> getPlayers() {
        return players;
    }

    //player 추가 로직
    public void addPlayer(Player player){
        players.add(player);
    }

}
