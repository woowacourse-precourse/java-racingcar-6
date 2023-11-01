package racingcar.domain.racing;

import java.util.List;
import racingcar.domain.IndexModel;
import racingcar.domain.racing.car.Car;

/**
 * 하나의 레이싱 게임 데이터를 담는 Model입니다. 참가자 목록, 시도 횟수, 우승자 목록을 관리합니다.
 */
public class RacingGame extends IndexModel {

    private Participations participations;
    private TryCount tryCount;
    private Winners winners;

    private RacingGame(Participations participations, TryCount tryCount, Winners winners) {
        this.participations = participations;
        this.tryCount = tryCount;
        this.winners = winners;
    }

    public static RacingGame create(Participations participations, TryCount tryCount, Winners winners) {
        return new RacingGame(participations, tryCount, winners);
    }

    public int getTryCount() {
        return tryCount.getTryCount();
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
