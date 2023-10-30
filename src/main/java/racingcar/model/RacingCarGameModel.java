package racingcar.model;

import java.util.List;

public class RacingCarGameModel {
    private RacingCarPlayerListModel players;
    private int tryCount;

    public RacingCarGameModel(List<RacingCarPlayerModel> players, int tryCount){
        this.players = new RacingCarPlayerListModel(players);
        this.tryCount = tryCount;
    }

    public void movePlayers(){
        this.players.movePlayers();
    }

    public int getTryCount(){
        return this.tryCount;
    }

    public List<RacingCarPlayerModel> getPlayers(){
        return this.players.players();
    }

    public List<RacingCarPlayerModel> getWinners(){
        int maxPosition = this.players.getMaxPosition();
        return this.players.filterPlayersByPosition(maxPosition);
    }
}
