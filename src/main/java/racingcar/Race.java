package racingcar;

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
            Printer.gameResultPrinter(raceParticipants.getRaceParticipants());
            moveCount.decreaseCount();
        }
        Printer.winnerPrinter(RaceRule.getWinner(raceParticipants));
    }
}
