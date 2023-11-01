package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingCar;
import utils.OutputUtil;


public class RacingCarGameOutputTest {
    @BeforeEach
    private void setUp() {
        OutputUtil.setUp();
    }

    @Test
    void printResultMessage_메소드를_사용시_실행_결과들이_출력() {
        List<RacingCar> carList = List.of(
                new RacingCar("pobi"),
                new RacingCar("woni"));
        carList.get(0).moveForword();
        RacingCarGameOutput.printGameProgress(carList);

        assertThat(OutputUtil.getOutputString()).isEqualTo("pobi : -\nwoni :");
    }

    @Test
    void printWinnerMessage_메소드를_사용시_1대의_우승한_자동차_출력() {
        List<RacingCar> carList = List.of(
                new RacingCar("woni")
        );
        RacingCarGameOutput.printWinnersMessage(carList);

        assertThat(OutputUtil.getOutputString()).isEqualTo("최종 우승자 : woni");
    }

    @Test
    void printWinnerMessage_메소드를_사용시_2대이상의_우승한_자동차들_출력() {
        List<RacingCar> carList = List.of(
                new RacingCar("pobi"),
                new RacingCar("woni"),
                new RacingCar("javaji")
        );
        RacingCarGameOutput.printWinnersMessage(carList);

        assertThat(OutputUtil.getOutputString()).isEqualTo("최종 우승자 : pobi, woni, javaji");
    }
}
