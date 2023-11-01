package racingcar.execution;

import racingcar.data.attempt.Attempt;

public class ConsoleOutput implements GameOutput {
    @Override
    public void print(String output) {
        System.out.println(output);
    }

    @Override
    public void print(Attempt attempt) {
        System.out.println(attempt);
        System.out.println();
    }
}
