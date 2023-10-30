package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("최종 우승자를 보여주는 기능 테스트")
    @Test
    void showFinalWinnerTest() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.goForward(4);
        car1.goForward(6);
        car1.goForward(8);

        car2.goForward(6);
        car2.goForward(7);
        car2.goForward(8);

        car3.goForward(1);
        car3.goForward(2);
        car3.goForward(5);

        List<Car> carList = new ArrayList<>(List.of(car1, car2, car3));
        Cars cars = new Cars(carList);

        String expected = "최종 우승자 : car1, car2";

        // when
        OutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));
        cars.showFinalWinner();

        // then
        assertThat(result.toString()).isEqualTo(expected);
    }

}