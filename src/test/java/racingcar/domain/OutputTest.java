package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

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
    void 전진하는_자동차_이름과_같이_출력(int count, String expected) {
        Car car = new Car("pobi");

        for (int i = 0; i < count; ++i) {
            car.moveForward(4);
        }
        Output.printCar(car);

        assertThat(output.toString().trim()).isEqualTo(expected);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi"), "최종 우승자 : pobi"),
                Arguments.of(Arrays.asList("pobi", "woni"), "최종 우승자 : pobi, woni")
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void 우승자_여러_명일_경우_쉼표로_구분해서_출력(List<String> winners, String expected) {

        Output.printWinners(winners);

        assertThat(output.toString().trim()).isEqualTo(expected);
    }
}