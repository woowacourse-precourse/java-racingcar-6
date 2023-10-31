package racingcar.io.writer;

public class OutputWriter implements StdWriter {
    @Override
    public void write(String message) {
        System.out.print(message);
    }

    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }
}
