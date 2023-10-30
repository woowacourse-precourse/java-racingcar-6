package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Name;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private static final int MOVING_NUMBER = 4;
    private OutputView outputView;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {

        System.setOut(new PrintStream(outContent));
        outputView = new OutputView();
    }

    @AfterEach
    void restoreStreams() {

        System.setOut(originalOut);
    }

    @Test
    @DisplayName("printStartGameMessage() 메서드는 게임 시작 메시지를 출력한다.")
    void testPrintStartGameMessage() {
        // given

        // when
        outputView.printStartGameMessage();

        // then
        assertThat(outContent.toString()).hasToString("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
    }

    @Test
    @DisplayName("askHowManyTimesToMove() 메서드는 몇 회 움직일지 묻는 메시지를 출력한다.")
    void testAskHowManyTimesToMove() {
        // given

        // when
        outputView.askHowManyTimesToMove();

        // then
        assertThat(outContent.toString()).hasToString("시도할 회수는 몇회인가요?\n");
    }

    @Test
    @DisplayName("printResultMessage() 메서드는 실행 결과 메시지를 출력한다.")
    void testPrintResultMessage() {
        // given

        // when
        outputView.printResultMessage();

        // then
        assertThat(outContent.toString()).hasToString("실행 결과\n");
    }

    @Test
    @DisplayName("printResult() 메서드는 자동차의 이름과 위치를 출력한다.")
    void testPrintResult() {
        // given
        List<Car> cars = List.of(new Car("car1"), new Car("car2"));
        cars.get(0).tryMove(MOVING_NUMBER);
        cars.get(1).tryMove(MOVING_NUMBER);
        cars.get(1).tryMove(MOVING_NUMBER);

        // when
        outputView.printResult(cars);

        // then
        String expectedOutput = "car1 : -\n" + "car2 : --\n\n";
        assertThat(outContent.toString()).hasToString(expectedOutput);
    }

    @Test
    @DisplayName("printWinner() 메서드는 우승자를 출력한다.")
    void testPrintWinner() {
        // given
        List<Name> winners = List.of(new Name("car1"), new Name("car3"));

        // when
        outputView.printWinner(winners);

        // then
        assertThat(outContent.toString()).hasToString("최종 우승자 : car1, car3\n");
    }
}
