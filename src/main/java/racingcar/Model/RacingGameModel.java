package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
