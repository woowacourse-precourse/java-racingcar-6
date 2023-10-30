package racingcar.Model;

import java.util.List;

public class RacingGameModel {
    List<String> carNames;
    int turns;

    public void setGameNames(List<String> inputs){
        this.carNames = inputs;
    }

    public void setGameTurns(int turn) {
        this.turns = turn;
    }

    public List<String> getGameNames() {
        return this.carNames;
    }

    public int getTurns() {
        return turns;
    }
}
