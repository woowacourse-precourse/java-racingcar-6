package racingcar.carRacing.service;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.carRacing.model.CarRacing;

public class CarRacingResultServiceTest {

    private CarRacingGameService carRacingGameService;

    @BeforeEach
    public void beforEach() {
        carRacingGameService = new CarRacingGameService(new CarRacing());
    }

    @AfterEach
    public void closeConsoleEach() {
        Console.close();
    }

    @Test
    void 지정_회수만큼_게임_진행() {
        String input = "pobi,woni,jun\n" + "3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        carRacingGameService.waitInput();
        carRacingGameService.doRace();

        assertThat(out.toString()).contains("pobi : ", "woni : ", "jun : ");
    }

}
