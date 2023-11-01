package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;
import racingcar.dto.Players;

public class RaceService {

    private final int MIN_RANDOM_NUMBER = 0;
    private final int MAX_RANDOM_NUMBER = 9;
    private final int STANDARD_NUMBER = 4;


    public void raceOneSimulate(Players players) {

        IntStream.range(0, players.getPlayersList().toArray().length).forEach(
                index -> simulateOnePlayer(players, index)
        );

    }

    private void simulateOnePlayer(Players players, int index) {

        if (isMove(Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER))) {
            players.moveForwardStep(index);
        }

    }

    private boolean isMove(int randomValue) {

        if (randomValue >= STANDARD_NUMBER) {
            return true;
        }
        return false;
    }

}
