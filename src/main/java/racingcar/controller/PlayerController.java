package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Player;

public class PlayerController {
    private List<Player> playerList;
    public PlayerController() {
        this.playerList = new ArrayList<>();
    }
    public void addPlayers(List<String> carNames) {
        for(String carName : carNames) {
            Player player = new Player(carName);
            playerList.add(player);
        }
    }
    public List<Player> getPlayerList() {
        return playerList;
    }
    public Player getPlayer(int index) {
        return playerList.get(index);
    }

    public int getCompletedRounds(int index) {
        return getPlayer(index).getCompletedRounds();
    }

    public void forward(int index) {
        getPlayer(index).increaseCompletedRounds();
    }

    public int getSizeOfTotalPlayers() {
        return playerList.size();
    }

    public String getCarNameOfThePlayer(int index) {
        return getPlayer(index).getCarName();
    }
}
