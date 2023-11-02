package racingcar.repository;

public class RoundRepository {

    private static final RoundRepository instance = new RoundRepository();

    public static RoundRepository getInstance() {
        return instance;
    }

    private int round = 0;

    public void setRound(int round) {
        this.round = round;
    }

    public int getRound() {
        return round;
    }
}
