package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class IOTest {
    private final ByteArrayOutputStream captor = new ByteArrayOutputStream();
    private PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void afterEachMethod() {
        System.setOut(standardOut);
        System.out.println(output());
        captor.reset();
        Console.close();
    }

    protected InputStream generateInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    protected SequenceInputStream generateMultipleStream(String... inputs) {
        List<InputStream> inputStreamList = new ArrayList<>();
        for (String input : inputs) {
            inputStreamList.add(generateInputStream(input));
        }

        return new SequenceInputStream(Collections.enumeration(inputStreamList));
    }


    protected void setInInputStream(InputStream generatedInputStream) {
        System.setIn(generatedInputStream);
    }

    protected String output() {
        return captor.toString().trim();
    }

}
