package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Race;

public class RaceViewTest {

    final List<String> CAR_NAMES = Arrays.asList("Car1", "Car2");

    OutputStream out;

    @BeforeEach
    void 문자열로_출력() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    void 레이스_초기상태_출력() {
        RaceView raceView = new RaceView();
        Race race = new Race(CAR_NAMES);

        raceView.printRace(race);
        assertThat(out.toString())
                .contains("Car1 : ", "Car2 : ");
    }

    @Test
    void 레이스_진행시_출력() {
        RaceView raceView = new RaceView();
        Race race = new Race(CAR_NAMES);

        race.doAttempt();
        race.doAttempt();

        raceView.printRace(race);
        assertThat(out.toString())
                .contains("Car1 : ", "Car2 : ")
                .contains("-");
    }

    @AfterAll
    void 콘솔로_출력() {
        System.setOut(System.out);
    }

}
