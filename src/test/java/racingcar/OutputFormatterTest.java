package racingcar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


class OutputFormatterTest {

    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void printCurrentStateOfRace() {
        Racer racer1 = new Racer("pobi");
        Racer racer2 = new Racer("woni");
        racer1.increaseProgress();
        racer1.increaseProgress();
        racer2.increaseProgress();
        Racer[] racers = {racer1, racer2};

        OutputFormatter.printCurrentStateOfRace(racers);

        assertEquals("pobi : --\r\nwoni : -\r\n", outputContent.toString());
    }



    @Test
    void printNamesOfRacers() {
        List<Racer> racers = Arrays.asList(new Racer("pobi"), new Racer("woni"));

        OutputFormatter.printNamesOfRacers(racers);

        assertEquals("pobi, woni", outputContent.toString());
    }
}