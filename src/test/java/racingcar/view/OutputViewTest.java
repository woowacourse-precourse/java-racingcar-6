package racingcar.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

    @DisplayName("printRacing() 메서드의 단일 자동차 객체 넘겨주어 이름, 전진 횟수를 출력한다.")
    @Test
    void 자동차_객체_출력() {
        OutputView.printRacing("yeon", 5);
        assertEquals("yeon : -----\r\n", output.toString());
    }

    @DisplayName("printWinner() 메서드에 객체를 넘겨주어 단일 우승차를 출력한다.")
    @Test
    void 단독_우승차_출력() {
        OutputView.printWinner(List.of(new Car("yeon")));
        assertEquals("최종 우승자 : yeon\r\n", output.toString());
    }

    @DisplayName("printWinner() 메서드에 객체를 넘겨주어 다중 우승차를 출력한다.")
    @Test
    void 다중_우승차_출력() {
        OutputView.printWinner(List.of(new Car("yeon"), new Car("jjang")));
        assertEquals("최종 우승자 : yeon, jjang\r\n", output.toString());
    }
}