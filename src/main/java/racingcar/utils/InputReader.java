package racingcar.utils;

import static racingcar.exception.ExceptionConstant.INPUT_EXCEPTION;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
    private final BufferedReader bufferedReader;

    public InputReader() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException exception) {
            throw new IllegalArgumentException(INPUT_EXCEPTION, exception);
        }
    }
}
