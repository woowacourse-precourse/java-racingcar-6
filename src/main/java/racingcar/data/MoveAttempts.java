package racingcar.data;

import java.util.ArrayList;
import java.util.List;

public class MoveAttempts {
    private final List<Attempt> attempts;

    public MoveAttempts() {
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
        attempts.get(0).initRacingCars(racingCarNameData);
    }

    public void initNewAttempt(int index) {
        createAttempt(attempts.get(index - 1));
        attempts.get(index).initRandomNumbers();
    }
}
