package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OutputTest {
    @Test
    void 라운드_결과_출력_테스트() {
        // given
        String expectOutput = "pobi : -\nwoni : \n\n";
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        cars.add(car1);
        cars.add(car2);

        // when
        car1.move();
        OutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        Output.viewResultOfRound(cars);

        // then
        Assertions.assertThat(actualOutput.toString()).isEqualTo(expectOutput);
    }

    @Test
    void 최종_결과_출력_테스트() {
        // given
        String expectOutput = "최종 우승자 : pobi, woni\n";
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        cars.add(car1);
        cars.add(car2);

        // when
        car1.move();
        car2.move();
        OutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));
        Output.viewResultOfGame(cars);

        // then
        Assertions.assertThat(actualOutput.toString()).isEqualTo(expectOutput);
    }
}