package racingcar.execution;

import racingcar.data.attempt.Attempt;

public interface GameOutput {
    void print(String output);
    void print(Attempt attempt);
}
