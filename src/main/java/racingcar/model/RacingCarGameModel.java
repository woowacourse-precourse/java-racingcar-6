package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameModel {
    private List<RacingCarPlayerModel> players;
    private int tryCount;

    public RacingCarGameModel() {
        this.players = new ArrayList<>();
    }

    public void setPlayers(List<RacingCarPlayerModel> players){
        this.players = players;
    }

    public void setTryCount(int tryCount){
        this.tryCount = tryCount;
    }

    public int getMaxPosition(){
        return this.players.stream().mapToInt(RacingCarPlayerModel::getCurrentPosition).max().orElse(0);
    }

    public void movePlayers(){
        this.players.forEach(RacingCarPlayerModel::move);
    }

    public int getTryCount(){
        return this.tryCount;
    }

    public List<RacingCarPlayerModel> getPlayers(){
        return this.players;
    }

    public List<RacingCarPlayerModel> getWinners(){
        int maxPosition = this.getMaxPosition();
        return this.players.stream().filter(player -> player.getCurrentPosition() == maxPosition).toList();
    }
}
