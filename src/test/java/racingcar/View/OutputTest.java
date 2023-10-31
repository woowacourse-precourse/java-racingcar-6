package racingcar.View;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputTest {
    private static Output output;

    @BeforeAll
    public static void setup() {
        output = new Output();
    }

    @Test
    void canForward() {

        System.setIn(new ByteArrayInputStream("6".getBytes()));
        boolean result = output.canForward();
        assertEquals(true,result);

    }

    @Test
    void saveForward() {
        final boolean fake=false;
        assertThat(output.saveForward(fake)).isEqualTo("");
    }

    @Test
    void printRaceRound() {
        Map<String, String> list = new HashMap<>();
        list.put("hi", "-");
        list.put("ho", "---");
        list.put("hoot", "-");



        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        output.printRaceRound(list);

        assertThat(outContent.toString().trim()).isEqualTo("hi : -\nho : ---\nhoot : -");
    }
}