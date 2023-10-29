package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Player;

public class PlayerController {
    private List<Player> playerList;
    public PlayerController() {
        this.playerList = new ArrayList<>();
    }
    public void addPlayer(List<String> carNames) {
        for(String carName : carNames) {
            Player player = new Player(carName);
            playerList.add(player);
        }
    }
    public List<Player> getPlayerList() {
        return playerList;
    }
}
