package racingcar.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.model.Round;
import racingcar.view.inputview.RegisterRoundInputView;
import racingcar.view.outputview.RegisterRoundOutputView;

public class RegisterRoundControllerTest extends IOTest {
    private Controller controller = new RegisterRoundController(
            new RegisterRoundOutputView(),
            new RegisterRoundInputView()
    );
    private final Map<String, Object> model = new HashMap<>();

    private static Stream<Arguments> generateRound() {
        return Stream.of(
                Arguments.of("5")
        );
    }

    private static Stream<Arguments> generateUnvalidRound() {
        return Stream.of(
                Arguments.of("015")
        );
    }

    @ParameterizedTest(name= " {0} ")
    @MethodSource("generateRound")
    void 출력_내용_확인(String inputRound) {
        setInInputStream(generateInputStream(inputRound));
        controller.process(model);

        Round round = (Round) model.get("round");

        Assertions.assertThat(round.getRound()).isEqualTo(5);
    }

    @ParameterizedTest(name = " {0} ")
    @MethodSource("generateUnvalidRound")
    void 예외가_발생한_경우(String inputRound) {
        setInInputStream(generateInputStream(inputRound));

        Assertions.assertThatThrownBy(() -> controller.process(model))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("0으로");
    }


}
