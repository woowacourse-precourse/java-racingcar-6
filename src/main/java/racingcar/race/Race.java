package racingcar.race;

import racingcar.race.rule.RaceRule;
import racingcar.utils.Printer;
import racingcar.car.CarRegistration;

public class Race {
    private final CarRegistration raceParticipants;
    private final MoveCount moveCount;
    private final RaceRule raceRule;

    public Race(CarRegistration raceParticipants, MoveCount moveCount, RaceRule raceRule) {
        this.raceParticipants = raceParticipants;
        this.moveCount = moveCount;
        this.raceRule = raceRule;
    }

    public void start() {
        while (moveCount.isRemained()) {
            raceRule.round(raceParticipants.getList());
            Printer.gameResultPrinter(raceParticipants.getList());
            moveCount.decreaseCount();
        }
        Printer.winnerPrinter(raceRule.getWinner(raceParticipants.getList()));
    }

    @Override
    public String toString() {
        return "Race{" +
                "raceParticipants=" + raceParticipants +
                ", moveCount=" + moveCount +
                '}';
    }
}
