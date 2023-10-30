package racingcar.domain.player;

import java.math.BigInteger;
import java.util.List;

public interface RacingPlayer {
        List<String> submitRacingCarNameList(int nameLength);

        BigInteger submitLaps();
}
