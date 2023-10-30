package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class OutputViewTest {

    private static final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("자동차_객체_출력")
    @Test
    void 자동차_객체_출력() {
        OutputView.printRacing("yeon", 5);
        assertEquals("yeon : -----\r\n", output.toString());
    }

    @DisplayName("우승차_출력")
    @Test
    void 우승차_출력() {
        OutputView.printWinner(List.of(new Car("yeon")));
        assertEquals("최종 우승자 : yeon\r\n", output.toString());
    }
}