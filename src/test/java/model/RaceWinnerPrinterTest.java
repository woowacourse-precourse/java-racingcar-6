package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceWinnerPrinterTest {

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
    public void print_전체_인원이_한명만_존재할_경우() {
        HashMap<String, String> hs = new HashMap<>();
        hs.put("aa", "-----");
        RaceDto raceDto = new RaceDto(hs, 5);
        RaceWinnerPrinter raceWinnerPrinter = new RaceWinnerPrinter(raceDto);

        raceWinnerPrinter.print();

        assertThat(output.toString()).contains("최종 우승자 : aa\n");
    }

    @Test
    public void print_우승자가_한명만_존재할_경우() {
        HashMap<String, String> hs = new HashMap<>();
        hs.put("aa", "-----");
        hs.put("bb", "----");
        RaceDto raceDto = new RaceDto(hs, 5);
        RaceWinnerPrinter raceWinnerPrinter = new RaceWinnerPrinter(raceDto);

        raceWinnerPrinter.print();

        assertThat(output.toString()).contains("최종 우승자 : aa\n");
    }

    @Test
    public void print_우승자가_세명_존재할_경우() {
        HashMap<String, String> hs = new HashMap<>();
        hs.put("aa", "-----");
        hs.put("bb", "-----");
        hs.put("cc", "----");
        hs.put("dd", "-----");
        RaceDto raceDto = new RaceDto(hs, 5);
        RaceWinnerPrinter raceWinnerPrinter = new RaceWinnerPrinter(raceDto);

        raceWinnerPrinter.print();

        assertThat(output.toString()).contains("최종 우승자 :", "aa", "bb", "dd");
        long commaCount = output.toString().chars().filter(c -> c == ',').count();
        assertThat(commaCount).isEqualTo(2);
    }
}