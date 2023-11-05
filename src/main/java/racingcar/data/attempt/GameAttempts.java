package racingcar.data.attempt;

import java.util.ArrayList;
import java.util.List;

public class GameAttempts {
    private final List<Attempt> attempts;

    public GameAttempts() {
        this.attempts = new ArrayList<>();
    }

    public void createAttempt() {
        Attempt newAttempt = new Attempt();
        attempts.add(newAttempt);
    }

    public void createAttempt(Attempt prevAttempt) {
        Attempt newAttempt = new Attempt(prevAttempt);
        attempts.add(newAttempt);
    }

    public void initBasicAttempt(String racingCarNameData) {
        findAttemptByIndex(0).initRacingCars(racingCarNameData);
    }

    public void initNewAttempt(int index) {
        createAttempt(findAttemptByIndex(index - 1));
        attempts.get(index).initRandomNumbers();
    }

    public void apply(int index) {
        String moves = findAttemptByIndex(index).decideMoves();
        findAttemptByIndex(index).moveRacingCars(moves);
    }

    public Attempt findAttemptByIndex(int index) {
        return attempts.get(index);
    }

    public List<String> findWinnersByIndex(int index) {
        return attempts.get(index).getWinners();
    }
}
