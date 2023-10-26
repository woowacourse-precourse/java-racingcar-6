package view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;
import model.Cars;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OutputViewTest {

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

    @ParameterizedTest(name = "winner : {1}")
    @MethodSource("carsAndWinner")
    @DisplayName("올바른 최종 우승자 출력하는지")
    public void 최종_우승자_출력_테스트(Cars cars, String result) {
        //given
        cars.indexAt(1).increaseMovingCountIfGreater(4, 5);

        //when
        OutputView.displayFinalWinner(cars);

        //then
        assertThat(result).isEqualTo(outputStreamCaptor.toString().trim());

    }

    static Stream<Arguments> carsAndWinner() {
        return Stream.of(
                Arguments.arguments(new Cars(new String[]{"tree", "cap", "ant", "sky"}), "cap"),
                Arguments.arguments(new Cars(new String[]{"cap", "tree", "ant", "sky"}), "tree"),
                Arguments.arguments(new Cars(new String[]{"tree", "fire", "ant", "sky"}), "fire"),
                Arguments.arguments(new Cars(new String[]{"tree", "sky", "ant", "xxx"}), "sky"),
                Arguments.arguments(new Cars(new String[]{"tree", "web", "ant", "sky"}), "web"),
                Arguments.arguments(new Cars(new String[]{"tree", "back", "ant", "sky"}), "back"));
    }
}
