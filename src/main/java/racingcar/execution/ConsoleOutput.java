package racingcar.execution;

public class ConsoleOutput implements GameOutput {
    @Override
    public void printString(String output) {
        System.out.println(output);
    }
}
