package racingcar.broadcaster;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BroadcasterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restore() {
        System.setOut(originalOut);
    }
    @Test
    void Broadcaster는_실행_결과를_입출력_형태에_맞춰_사용자에게_보여준다(){
        // given
        Map<String, Integer> fakeRaceResult = new LinkedHashMap<>();
        fakeRaceResult.put("car1", 3);
        fakeRaceResult.put("car2", 4);
        fakeRaceResult.put("car3", 5);

        // when
        Broadcaster.printCurrentRace(fakeRaceResult);

        // then
        assertThat(outContent.toString())
                .isEqualTo("car1 : ---\n" +
                                "car2 : ----\n" +
                                "car3 : -----\n\n");
    }
    @Test
    void Broadcaster는_최종_우승자를_입출력_형태에_맞춰_사용자에게_보여준다(){
        // given
        List<String> fakeWinner = List.of("car1","car2");

        // when
        Broadcaster.printWinner(fakeWinner);

        // then
        assertThat(outContent.toString())
                .isEqualTo("최종 우승자 : car1, car2\n");
    }
}
