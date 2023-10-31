package racingcar.play;

import org.junit.jupiter.api.Test;
import racingcar.model.car.Cars;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayRacingGameTest {

    @Test
    void inputTest() {
        PlayRacingGame playRacingGame = new PlayRacingGame();
        String inputName = "one,two,three\n5";
        System.setIn(new ByteArrayInputStream(inputName.getBytes()));

        playRacingGame.input();

        assertThat(playRacingGame.getCars().getCars().size()).isEqualTo(3);
        assertThat(playRacingGame.getRoundCount()).isEqualTo(5);
    }

    @Test
    void playTest() {
        PlayRacingGame playRacingGame = new PlayRacingGame();

        Cars cars = new Cars("one,two,three");

        playRacingGame.setCars(cars);

        playRacingGame.setRoundCount(5);

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        PrintStream standardOut = System.out;

        System.setOut(new PrintStream(outputStreamCaptor));

        playRacingGame.getCars().getCars().get(0).setCount(10);
        playRacingGame.play();

        System.setOut(standardOut);

        System.out.println(outputStreamCaptor);

        assertThat(outputStreamCaptor.toString()).contains("one", "two", "three", "-");
        assertThat(playRacingGame.getMaxCount()).isGreaterThan(10); //maxCount가 10 이상인지 확인

    }

    @Test
    void printGameResultTest() {
        PlayRacingGame playRacingGame = new PlayRacingGame();
        Cars cars = new Cars("one,two,three");

        playRacingGame.setCars(cars);
        playRacingGame.getCars().getCars().get(0).setCount(10);

        playRacingGame.setMaxCount(10);


        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        PrintStream standardOut = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));
        playRacingGame.printGameResult();

        System.setOut(standardOut);

        System.out.println(outputStreamCaptor);
        assertThat(outputStreamCaptor.toString()).contains("one");

    }

    @Test
    void inputNameExceptionTest() {
        String input = "dongha,pobi,jun";
        PlayRacingGame playRacingGame = new PlayRacingGame();
        playRacingGame.setCars(new Cars(input));

        assertThrows(IllegalArgumentException.class, () -> {
            playRacingGame.inputNameException();
        });
    }

    @Test
    void inputRoundCountExceptionTest() {
        PlayRacingGame playRacingGame = new PlayRacingGame();


        assertThrows(IllegalArgumentException.class, () -> {
            playRacingGame.inputRoundCountException("-1");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            playRacingGame.inputRoundCountException("");
        });
    }
}
