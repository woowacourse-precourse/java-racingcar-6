package racingcar.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class OutputViewTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
    @DisplayName("startTest")
    @Test
    void startTest() {
        //given
        OutputView outputView = new OutputView();
        //when
        outputView.start();
        //then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("실행 결과");
    }

    @DisplayName("printResultTest")
    @Test
    void printResultTest() {
        //given
        OutputView outputView = new OutputView();
        //when
        outputView.printResult(Arrays.asList("poby", "woni", "jun"));
        //then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("최종 우승자 : poby, woni, jun");
    }

    @DisplayName("printStandingTest")
    @Test
    void printStandingTest() {
        //given
        OutputView outputView = new OutputView();
        List<Car> cars = Arrays.asList(Car.of("poby"), Car.of("woni"), Car.of("jun"));
        //when
        outputView.printStanding(cars);
        //then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("poby : " + System.lineSeparator() + "woni : " + System.lineSeparator() + "jun :");
    }
}