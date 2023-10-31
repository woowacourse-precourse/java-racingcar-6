package racingcar.execution;

public class ConsoleOutput implements GameOutput {
    @Override
    public void print(String output) {
        System.out.println(output);
    }
}
