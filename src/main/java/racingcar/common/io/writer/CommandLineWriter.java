package racingcar.common.io.writer;

public class CommandLineWriter implements Writer {

    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }
}
