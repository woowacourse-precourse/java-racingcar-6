package racingcar.output;

public class ConsoleOutput implements Output{

    @Override
    public void outputMessage(String message) {
        System.out.print(message);
    }
}
