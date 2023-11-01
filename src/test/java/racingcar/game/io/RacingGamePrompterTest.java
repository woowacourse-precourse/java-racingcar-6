package racingcar.game.io;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingGamePrompterTest extends RacingGamePrompter {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalSysOut = System.out;
    private final InputStream originalSysIn = System.in;

    @BeforeEach
    void setSysOutBeforeEachTest() {
        System.setOut(new PrintStream(outContent));
    }
    @AfterEach
    void setSysOutAfterEachTest() {
        System.setOut(originalSysOut);
        System.setIn(originalSysIn);
    }

    @Test
    void testPromptNames_Basic() {
//        System.setIn(new ByteArrayInputStream("pobi,woni,jun".getBytes()));
//        List<String> names = promptNames();
//        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n", outContent.toString());
//        assertEquals(List.of("pobi", "woni", "jun"), names);
    }
    @Test
    void testPromptNames_LongName() {
//        System.setIn(new ByteArrayInputStream("aaaaaa,bbb,ccc".getBytes()));
//        assertThatThrownBy(() -> {
//            List<String> names = promptNames();
//        }).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("Name should be shorter than 6");
    }

    @Test
    void testPromptRounds() {
//        System.setIn(new ByteArrayInputStream("11".getBytes()));
//        Integer rounds = promptRounds();
//        assertEquals("시도할 회수는 몇회인가요?\n", outContent.toString());
//        assertEquals(11, rounds);
    }
    @Test
    void testPromptRounds_NonDigit() {
//        System.setIn(new ByteArrayInputStream("AA".getBytes()));
//        assertThatThrownBy(() -> {
//            promptRounds();
//        }).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("User input is not integer");
    }

}
