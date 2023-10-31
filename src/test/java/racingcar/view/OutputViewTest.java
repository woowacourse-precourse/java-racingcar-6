package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarDistanceMessage;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    private final static PrintStream stdout = System.out;
    private final static ByteArrayOutputStream captor = new ByteArrayOutputStream();

    private String output() {
        return captor.toString().trim();
    }

    @BeforeAll
    public static void beforeAll() {
        System.setOut(new PrintStream(captor));
    }

    @AfterAll
    public static void afterAll() {
        System.setOut(stdout);
    }

    @Test
    void printCarDistanceMessages_출력_확인() {

        OutputView outputView = new OutputView();
        List<CarDistanceMessage> messages = List.of(new CarDistanceMessage("foo", 1));

        outputView.printCarDistanceMessages(messages);

        String log = output();
        Assertions.assertThat(log).contains("foo : -");

    }

}