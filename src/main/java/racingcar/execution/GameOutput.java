package racingcar.execution;

import racingcar.data.Attempt;

public interface GameOutput {
    public abstract void print(String output);
    public abstract void print(Attempt attempt);
}
