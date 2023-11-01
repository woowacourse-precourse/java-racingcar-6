package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AttemptResultPrinterTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUpStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoresStream() {
        System.setOut(System.out);
    }

    @Test
    public void print_출력값이_정해진_형식을_맞추는지() {
        HashMap<String, String> hs = new HashMap<>();
        hs.put("aa", "---");
        hs.put("bb", "--");
        RaceDto raceDto = new RaceDto(hs, 4);
        AttemptResultPrinter attemptResultPrinter = new AttemptResultPrinter(raceDto);

        attemptResultPrinter.print();

        assertThat(output.toString()).contains("aa : ---\nbb : --\n");
    }
}