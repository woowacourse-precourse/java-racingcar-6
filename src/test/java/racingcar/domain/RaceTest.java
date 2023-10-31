package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.NumberGenerator;
import racingcar.domain.Race;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RaceTest {
    private Race race;
    NumberGenerator numberGenerator;

    @BeforeEach
    void makeTestRace() {
        race = new Race(Arrays.asList("name1", "name2", "name3"), 5);
    }

    @Test
    void 경주_실행() {
        ByteArrayOutputStream outputStream = getByteArrayOutputStream();
        race.play();
//        assertThat(outputStream.toString()).
    }

    private ByteArrayOutputStream getByteArrayOutputStream() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        return outputStream;
    }
}
