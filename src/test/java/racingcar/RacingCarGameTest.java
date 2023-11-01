package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class RacingCarGameTest {

    private RacingCarGame game;

    final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setByteArrayOutputStream() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @BeforeEach
    public void setUp() {
        game = new RacingCarGame();
    }

    @Test
    void setRacingCarNames_자동차_이름을_부여할_수_있고_쉼표를_기준으로_구분한다() {
        String testInput = "car1,car2,car3";
        game.setRacingCarNames(testInput);
        assertEquals(3, game.racingCars.size());
    }

    @Test
    void setTryIteration_사용자는_몇_번의_이동을_할_것인지를_입력할_수_있어야_한다() {
        game.setTryIteration("5");
        assertEquals(5, game.tryIteration);
    }

    @Test
    void printWinner_자동차_경주_게임을_완료한_후_누가_우승했는지를_알려준다() {
        game.setRacingCarNames("car1,car2,car3");
        game.racingCars.get(0).tryForward(4);
        game.printWinner();
        assertEquals("최종 우승자 : car1", byteArrayOutputStream.toString().trim());
    }

    @Test
    void printWinner_우승자는_여러_명일_경우_쉼표를_이용하여_구분한다() {
        game.setRacingCarNames("car1,car2,car3");
        game.racingCars.get(0).tryForward(4);
        game.racingCars.get(1).tryForward(4);
        game.printWinner();
        assertEquals("최종 우승자 : car1, car2", byteArrayOutputStream.toString().trim());
    }
}