package racingcar.domain;

import static racingcar.domain.GameStatus.GAME_OVER;
import static racingcar.domain.GameStatus.PLAYING;

public class Round {

    private int round;


    public void addRound() {
        ++round;
    }

    public GameStatus checkIfGameIsOver(int roundToRace) {
        if (round == roundToRace) {
            return GAME_OVER;
        }

        return PLAYING;
    }

}
