package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.Car;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class ViewTest {
    private static ByteArrayOutputStream output;

    @BeforeEach
    void setUpStreams() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("자동차 이름을 입력하라는 출력문을 띄우는 기능")
    void askForInputCarNames() {
        String msg = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
        InputView.askForInputCarNames();
        assertEquals(msg, output.toString());
    }

    @Test
    @DisplayName("시도할 회수를 묻는 출력문을 띄우는 기능")
    void askForNumbersOfAttempts() {
        InputView.askForNumbersOfAttempts();
        assertEquals("시도할 회수는 몇회인가요?\n", output.toString());
    }

    @Test
    @DisplayName("\"실행 결과\"를 출력하는 기능")
    void printHeadResult() {
        String msg = "\n실행 결과\n";
        OutputView.printHeadResult();
        assertEquals(msg, output.toString());
    }

    @Test
    @DisplayName("최종 우승자를 출력해주는 기능")
    void printWinner() {
        String winner = "pobi,jun,son";
        OutputView.printWinner(winner);
        String msg = "최종 우승자 : pobi,jun,son";
        assertEquals(msg, output.toString());
    }

    @Test
    @DisplayName("1라운드 실행 결과를 출력해주는 기능")
    void printOneRoundResult() {
        List<Car> cars = Arrays.asList(new Car("poni", 3), new Car("jun", 2));
        OutputView.printOneRoundResult(cars);
        assertThat(output.toString()).contains("poni : ---","jun : --");
    }

    @Test
    @DisplayName("자동차 이름과 전진 범위를 출력해주는 기능")
    void carToString() {
        Car car = new Car("son",4);
        String result  = car.toString();
        assertEquals(result,"son : ----");
    }
}
