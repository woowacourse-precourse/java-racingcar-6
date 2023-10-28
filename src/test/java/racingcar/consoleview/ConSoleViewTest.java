package racingcar.consoleview;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.view.ConsoleView;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class ConSoleViewTest {
    private PrintStream standardOut;
    private OutputStream captor;
    private ConsoleView consoleView = new ConsoleView();

    @BeforeEach
    void init(){
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }
    @AfterEach
    void backStandardStream() {
        System.setOut(standardOut);
    }
    String getOut(){
        return captor.toString().trim();
    }
    @ParameterizedTest
    @DisplayName("printWinner() 함수 테스트")
    @MethodSource("provide_printWinner_TestData")
    void 우승자에_따른_출력(List<String> winners, String expectedOutput) {
        consoleView.printWinner(new ArrayList<>(winners));
        assertThat(getOut()).isEqualTo(expectedOutput);
    }
    @ParameterizedTest
    @DisplayName("printRoundProgress() 함수 테스트")
    @MethodSource("provide_printRoundProgress_TestData")
    void 진행상황_테스트(String name, int winCount, String expectedOutput) {
        consoleView.printRoundProgress("희종", 2);
        assertThat(getOut()).isEqualTo("희종 : --");
    }


    private static Stream<Arguments> provide_printWinner_TestData() {
        return Stream.of(
                Arguments.of(Arrays.asList("희종"), "최종 우승자 : 희종"),
                Arguments.of(Arrays.asList("희종", "맹준"), "최종 우승자 : 희종, 맹준"),
                Arguments.of(Arrays.asList("지환"), "최종 우승자 : 지환")
        );
    }
    private static Stream<Arguments> provide_printRoundProgress_TestData() {
        return Stream.of(
                Arguments.of("희종", 3, "희종 : ---"),
                Arguments.of("희종", 0, "희종 : "),
                Arguments.of("희종", 10, "희종 : ----------")
        );
    }
}
