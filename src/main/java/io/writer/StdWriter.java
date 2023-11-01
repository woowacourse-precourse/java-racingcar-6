package io.writer;

public class StdWriter implements Writer {
    @Override
    public void write(String text) {
        System.out.print(text);
    }
}
