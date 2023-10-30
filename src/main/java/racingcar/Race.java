package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Race {
    private final CarRegistration raceParticipants;
    private final MoveCount moveCount;

    public Race(CarRegistration raceParticipants, MoveCount moveCount) {
        this.raceParticipants = raceParticipants;
        this.moveCount = moveCount;
    }

    public void start() {
        while (moveCount.isRemained()) {
            RaceRule.phase(raceParticipants);
//            Printer.GameResultPrinter(raceParticipants);
            moveCount.decreaseCount();
        }
    }
}
