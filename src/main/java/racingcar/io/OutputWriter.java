package racingcar.io;

public class OutputWriter implements Writer {

    @Override
    public void writeln(String msg) {
        System.out.println(msg);
    }

    @Override
    public void write(String msg) {
        System.out.print(msg);
    }
}
