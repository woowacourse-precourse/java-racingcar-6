package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingCar;
import racingcar.utils.RacingCarGameOutput;


public class RacingCarGameOutputTest {
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    private void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    private String getOutputString() {
        return outputStreamCaptor.toString().trim();
    }

    @Test
    void printResultMessage_메소드를_사용시_실행_결과들이_출력() {
        List<RacingCar> carList = List.of(
                new RacingCar("pobi"),
                new RacingCar("woni"));
        carList.get(0).moveForword();
        RacingCarGameOutput.printGameProgress(carList);
        assertThat(getOutputString()).isEqualTo("pobi : -\nwoni :");
    }

    @Test
    void printWinnerMessage_메소드를_사용시_1대의_우승한_자동차_출력() {
        List<RacingCar> carList = List.of(
                new RacingCar("woni")
        );
        RacingCarGameOutput.printWinnersMessage(carList);
        assertThat(getOutputString()).isEqualTo("최종 우승자 : woni");
    }

    @Test
    void printWinnerMessage_메소드를_사용시_2대이상의_우승한_자동차들_출력() {
        List<RacingCar> carList = List.of(
                new RacingCar("pobi"),
                new RacingCar("woni"),
                new RacingCar("javaji")
        );
        RacingCarGameOutput.printWinnersMessage(carList);
        assertThat(getOutputString()).isEqualTo("최종 우승자 : pobi, woni, javaji");
    }
}
