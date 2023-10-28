package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private OutputStream captor;
    private Race race;

    @BeforeEach
    protected final void init() {
        race = new Race("pobi,woni,jun");
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @Test
    public void testSetData(){
        assertEquals("pobi", race.getGameCar().get(0).getName());
        assertEquals("woni", race.getGameCar().get(1).getName());
        assertEquals("jun", race.getGameCar().get(2).getName());
    }

    @Test
    public void testPlayGame() {
        assertRandomNumberInRangeTest(
                () -> {
                    race.playGame("5");
                    assertThat(output()).contains("pobi : -", "woni : ","jun : -"
                                                 ,"pobi : --", "woni : -","jun : --"
                                                 ,"pobi : ---", "woni : --","jun : ---"
                                                 ,"pobi : ----", "woni : ---","jun : ----"
                                                 ,"pobi : -----", "woni : ----","jun : -----");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    public void testCheckWinner(){
        assertRandomNumberInRangeTest(
                () -> {
                    race.playGame("1");
                    assertEquals("pobi, jun", race.findWinner());
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD

        );
    }

    @Test
    public void testInvalidText(){
        assertThrows(IllegalArgumentException.class, () -> {
            race.playGame("asdf");
        });
    }

    private String output() {
        return captor.toString().trim();
    }

}
