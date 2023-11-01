package io;

import camp.nextstep.edu.missionutils.Console;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class InputTest {
    private Input userInput;
    private InputStream originalSystemIn;
    private PrintStream originalSystemOut;
    private ByteArrayInputStream mockInput;
    private ByteArrayOutputStream mockOutput;

    @BeforeEach
    public void setUp() {
        originalSystemIn = System.in;
        originalSystemOut = System.out;
        userInput = new Input();
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
        Console.close();
        userInput = null;
    }

    @Test
    void splitByComma_주어진_값을_쉼표로_구분() {
        String input = "koko,nana,mimi,akko";
        String[] result = userInput.splitByComma(input);

        assertThat(result).contains("koko", "nana", "mimi", "akko");
    }

    @Test
    void splitByComma_쉼표_없을_때_구분() {
        String input = "koko";
        String[] result = userInput.splitByComma(input);

        assertThat(result).contains("koko");
    }

    @ParameterizedTest
    @ValueSource(strings = {"koko,nana,mimi,akko", "koko,mimi", "koko"})
    void receiveCommaSeparatedString_쉼표로_구분된_값_입력(String input) {
        mockInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(mockInput);

        ArrayList<String> expectResult = new ArrayList<>(Arrays.asList(input.split(",")));
        ArrayList<String> result = userInput.receiveCommaSeparatedString();

        assertThat(result).isEqualTo(expectResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "4", "9", "1",})
    void receiveInteger_정수_값_입력(String input) {
        mockInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(mockInput);

        int result = userInput.receiveInteger();
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.123", "daki", "", " ", "12seaon", "home123",})
    void receiveInteger_정수가_아닌_값_입력_예외처리(String input) {
        mockInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(mockInput);

        assertThatThrownBy(() -> userInput.receiveInteger()).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"hello,daki", "bye,daki",})
    void prompt_출력확인(String greeting, String input) {
        mockInput = new ByteArrayInputStream(input.getBytes());
        mockOutput = new ByteArrayOutputStream();

        System.setIn(mockInput);
        System.setOut(new PrintStream(mockOutput));

        String result = userInput.prompt(greeting);
        String printedContent = mockOutput.toString();

        assertThat(greeting).isEqualTo(printedContent.trim());
        assertThat(input).isEqualTo(result);
    }
}
