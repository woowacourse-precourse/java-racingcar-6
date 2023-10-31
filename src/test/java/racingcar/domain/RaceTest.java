package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.generator.TestNumberGenerator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RaceTest {
    private Race race;
    private final int ROUNDS = 5;

    @BeforeEach
    void makeTestRace() {
        race = new Race(Arrays.asList("name1", "name2", "name3"), ROUNDS, new TestNumberGenerator());
    }

    @Test
    @DisplayName("자동차는 이동횟수 이상으로 움직일 수 없다.")
    void 경주_실행() {
        ByteArrayOutputStream outputStream = getByteArrayOutputStream();
        race.play();
        assertThat(outputStream.toString()).doesNotContain("-".repeat(ROUNDS + 1));
    }

    private ByteArrayOutputStream getByteArrayOutputStream() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        return outputStream;
    }

    @Test
    void 승자_구하기 () {
        List<Car> winners = race.getWinners();
        assertThat(winners.size()).isEqualTo(race.getCandidates().size());
    }
}
