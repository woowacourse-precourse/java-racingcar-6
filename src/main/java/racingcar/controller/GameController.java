package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Dice;
import racingcar.model.Game;

public class GameController {
    public Game makeGame(String maxRound) {
        return new Game(maxRound);
    }

    public Dice rollDiceTen() {
        return new Dice(Randoms.pickNumberInRange(0, 9));
    }

}
