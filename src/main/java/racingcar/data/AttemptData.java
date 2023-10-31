package racingcar.data;

import java.util.ArrayList;
import java.util.List;

public class AttemptData {
    private final List<Attempt> attempts;
    private final AttemptNumber attemptNumber;

    public AttemptData(int attemptNumber) {
        this.attempts = new ArrayList<>();
        this.attemptNumber = new AttemptNumber(attemptNumber);
    }

    public Attempt createAttempt() {
        Attempt newAttempt = new Attempt();
        attempts.add(newAttempt);
        return newAttempt;
    }
}
