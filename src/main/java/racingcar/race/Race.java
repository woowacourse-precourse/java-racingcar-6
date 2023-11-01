package racingcar.race;

import racingcar.race.rule.RaceRule;
import racingcar.utils.Printer;
import racingcar.car.CarRegistration;

public class Race {
    private final CarRegistration raceParticipants;
    private final RoundCount roundCount;
    private final RaceRule raceRule;

    public Race(CarRegistration raceParticipants, RoundCount roundCount, RaceRule raceRule) {
        this.raceParticipants = raceParticipants;
        this.roundCount = roundCount;
        this.raceRule = raceRule;
    }

    public void start() {
        while (roundCount.isRemained()) {
            raceRule.round(raceParticipants.getList());
            Printer.gameResultPrinter(raceParticipants.getList());
            roundCount.decreaseCount();
        }
        Printer.winnerPrint(raceRule.getWinner(raceParticipants.getList())); // winnerPrint일 것 같습니다. 근데, Printer가 WinnerPrinter라는 메서드를 갖는게 맞을까요?
    }

    @Override
    public String toString() {
        return "Race{" +
                "raceParticipants=" + raceParticipants +
                ", roundCount=" + roundCount +
                '}';
    }
}
