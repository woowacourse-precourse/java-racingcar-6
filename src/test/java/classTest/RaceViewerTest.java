package classTest;

import org.junit.jupiter.api.Test;
import racingcar.view.RaceViewer;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceViewerTest {
    private final RaceViewer viewer = new RaceViewer();

    @Test
    void show_우승자_테스트() {
        //given
        List<String> winners = Arrays.asList("jiyun","hoho");

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        viewer.showRaceWinner(winners);

        assertThat(out.toString()).contains("최종 우승자 : jiyun, hoho");
    }
}
