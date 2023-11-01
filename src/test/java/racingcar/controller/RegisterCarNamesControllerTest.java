package racingcar.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.view.inputview.RegisterCarNamesInputView;
import racingcar.view.outputview.RegisterCarNamesOutputView;

public class RegisterCarNamesControllerTest extends IOTest {
    private Controller controller = new RegisterCarNamesController(
            new RegisterCarNamesOutputView(),
            new RegisterCarNamesInputView()
    );

    private final Map<String, Object> model = new HashMap<>();

    private static Stream<Arguments> generateCarNames() {
        return Stream.of(
                Arguments.of("pobi, woni, jun"),
                Arguments.of("pobi,woni,jun")
        );
    }

    private static Stream<Arguments> generateUnvalidCarNames() {
        return Stream.of(
                Arguments.of("pobi, wonice, jun")
        );
    }

    @ParameterizedTest(name = " {0} ")
    @MethodSource("generateCarNames")
    void 출력_내용_확인(String inputNames) {
        setInInputStream(generateInputStream(inputNames));
        controller.process(model);

        RacingCars racingCars = (RacingCars) model.get("racingCars");

        Assertions.assertThat(output()).contains("입력하세요.");
        Assertions.assertThat(racingCars.getRacingCars())
                .containsExactly(
                        new Car("pobi"),
                        new Car("woni"),
                        new Car("jun"));
    }

    @ParameterizedTest(name = " {0} ")
    @MethodSource("generateUnvalidCarNames")
    void 예외가_발생한_경우(String inputNames) {
        setInInputStream(generateInputStream(inputNames));

        Assertions.assertThatThrownBy(() -> controller.process(model))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("5글자가");
    }
}
