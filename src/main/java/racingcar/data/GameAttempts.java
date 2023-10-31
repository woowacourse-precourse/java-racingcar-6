package racingcar.data;

import java.util.ArrayList;
import java.util.List;

public class GameAttempts {
    private final List<Attempt> attempts;

    public GameAttempts(int attemptNumber) {
        this.attempts = new ArrayList<>(attemptNumber);
    }

    public void createAttempt(int pickTotal) {
        Attempt newAttempt = new Attempt(pickTotal);
        attempts.add(newAttempt);
    }

    public void pickNewNumberByIndex(int index) {
        attempts.get(index).initRandomNumber();
    }
}
