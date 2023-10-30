package racingcar.domain;

public class Racing extends IndexModel {

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

    private Racing(Participations participations, int tryCount) {
        this.participations = participations;
        this.tryCount = tryCount;
    }

    public static Racing create(Participations participations, int tryCount) {
        return new Racing(participations, tryCount);
    }
}
