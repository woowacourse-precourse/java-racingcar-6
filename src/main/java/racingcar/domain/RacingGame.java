package racingcar.domain;

import java.util.List;

public class RacingGame extends IndexModel {

    private Participations participations;
    private int tryCount;
    private Winners winners;

    private RacingGame(Participations participations, int tryCount, Winners winners) {
        this.participations = participations;
        this.tryCount = tryCount;
        this.winners = winners;
    }

    public static RacingGame create(Participations participations, int tryCount, Winners winners) {
        return new RacingGame(participations, tryCount, winners);
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<Car> getWinnerList() {
        return winners.getWinners();
    }

    public int calcWinnerSize() {
        return getWinnerList().size();
    }

    public List<Car> getParticipationsList() {
        return participations.getParticipations();
    }

    public int calcParticipationSize() {
        return participations.size();
    }

    public int calcParticipationsMaxPosition() {
        return participations.calcMaxPosition();
    }

    public void addWinner(Car car) {
        winners.addWinner(car);
    }
}
