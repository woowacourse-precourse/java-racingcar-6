package racingcar.model;

import java.util.List;

public class CarGameModel {
    private final CarPlayerListModel players;
    private final int tryCount;

    public CarGameModel(List<CarPlayerModel> players, int tryCount) {
        this.players = new CarPlayerListModel(players);
        this.tryCount = tryCount;
    }

    public void movePlayers() {
        this.players.movePlayers();
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public List<CarPlayerModel> getPlayers() {
        return this.players.players();
    }

    public List<CarPlayerModel> getWinners() {
        int maxPosition = this.players.getMaxPosition();
        return this.players.filterPlayersByPosition(maxPosition);
    }
}
