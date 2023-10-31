package racingcar.domain;

public class RacingGame extends IndexModel {

    private Participations participations;
    private int tryCount;
    private Winners winners;


    public Participations getParticipations() {
        return participations;
    }

    public int getTryCount() {
        return tryCount;
    }

    public Winners getWinners() {
        return winners;
    }

    public void setWinners(Winners winners) {
        this.winners = winners;
    }

    private RacingGame(Participations participations, int tryCount) {
        this.participations = participations;
        this.tryCount = tryCount;
    }

    public static RacingGame create(Participations participations, int tryCount) {
        return new RacingGame(participations, tryCount);
    }

    public int participationSize() {
        return participations.size();
    }

    public Participations getParicipations() {
        return participations;
    }
}
