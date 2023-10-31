package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.io.OutputView;

class OutputViewTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void printRequestCarNamesTest() {
        //given
        //when
        OutputView.printRequestCarNames();

        //then
        Assertions.assertEquals(GameMessage.INPUT_CAR_NAMES.getMessage() + "\n", outputStream.toString());
    }

    @Test
    void printRequestTryCount() {
        // given
        // when
        OutputView.printRequestTryCount();
        // then
        Assertions.assertEquals(GameMessage.INPUT_TRY_COUNT.getMessage() + "\n", outputStream.toString());
    }

    @Test
    void printCarLocation() {
        // given
        RacingCar testCar = new RacingCar("test");
        // when
        OutputView.printCarLocation(testCar);
        // then
        Assertions.assertEquals(testCar.getName() + " : " + "\n", outputStream.toString());
    }

    @Test
    void printGameResultMessage() {
        // given
        // when
        OutputView.printGameResultMessage();
        // then
        Assertions.assertEquals(GameMessage.GAME_RESULT.getMessage() + "\n", outputStream.toString());
    }

    @Test
    void printResultMessage() {
        //given
        List<RacingCar> list = new ArrayList<>();
        list.add(new RacingCar("test1"));
        list.add(new RacingCar("test2"));

        //when
        OutputView.printResultMessage(list);
        //then
        Assertions.assertEquals(GameMessage.FINAL_WINNER.getMessage() + "test1" + "," + "test2" + "\n",
                outputStream.toString());
    }
}
