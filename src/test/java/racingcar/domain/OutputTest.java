package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OutputTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUpOutputStream() {
        System.setOut(new PrintStream(output));

    }

    @AfterEach
    void restoreOutputStream() {
        System.setOut(System.out);
        output.reset();
    }

    @ParameterizedTest
    @CsvSource({"1,pobi : -", "2,pobi : --"})
    void 전진하는_자동차_이름과_같이_출력(int count, String expected){
        Car car = new Car("pobi");

        for (int i = 0; i < count; ++i){
            car.moveForward(4);
        }
        Output.printCar(car);

        assertThat(output.toString().trim()).isEqualTo(expected);
    }
}