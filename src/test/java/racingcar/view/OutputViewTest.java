package racingcar.view;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class OutputViewTest {

    @DisplayName("실행결과를 출력하는 기능 테스트")
    @Test
    void printResultTest() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.goForward(4);
        car1.goForward(6);
        car1.goForward(8);

        car2.goForward(0);
        car2.goForward(8);
        car2.goForward(3);

        car3.goForward(1);
        car3.goForward(2);
        car3.goForward(5);

        List<Car> carList = new ArrayList<>(List.of(car1, car2, car3));

        String expected = "car1 : ---\ncar2 : -\ncar3 : -\n\n";

        // when
        OutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));
        OutputView.printResult(carList);

        // then
        assertThat(result.toString()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:-", "2:--", "3:---", "4:----"}, delimiter = ':')
    @DisplayName("전진 횟수에 따라 막대를 출력하는 기능 테스트")
    void printSticksTest(int n, String expected) {
        // when
        OutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));
        OutputView.printSticks(n);

        // then
        assertThat(result.toString().strip()).isEqualTo(expected);
    }

    @DisplayName("최종 우승자를 출력하는 기능 테스트")
    @Test
    void printFinalWinnerTest() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        List<Car> carList = new ArrayList<>(List.of(car1, car2));

        String expected = "최종 우승자 : car1, car2";

        // when
        OutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));
        OutputView.printFinalWinner(carList);

        // then
        assertThat(result.toString()).isEqualTo(expected);
    }

}