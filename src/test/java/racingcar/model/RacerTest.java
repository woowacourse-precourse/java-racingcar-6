package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.message.Message;
import racingcar.dto.Result;
import racingcar.service.Accelerator;
import racingcar.service.GeneratorTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacerTest {

    @DisplayName("잘못된 참가자 입력 체크")
    @ParameterizedTest(name = "{displayName}: {0}")
    @NullSource
    @ValueSource(strings = {"", ",", ",car", ",,,,,", ",,dk"})
    void checkRacer(String value) {
        assertThatThrownBy(() -> Racer.of(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 이름 체크")
    @ParameterizedTest(name = "{displayName}: {0}")
    @ValueSource(strings = {"ad,k,la,a,la", "l,l", "qwe,kz,pi,pi", "a, a,a ", "ba,l, ba"})
    void checkUnique(String value) {
        assertThatThrownBy(() -> Racer.of(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 이름 입력 체크")
    @ParameterizedTest(name = "{displayName}: {0}, {1}")
    @ValueSource(strings = {"12,345,675", "212 ,34, 5533", "ad,d dk,i"})
    void checkValidate(String value) {
        Racer racer = Racer.of(value);
        List<String> excepted = Arrays.stream(value.split(Message.NAME_SEPARATOR))
                .map(String::trim)
                .toList();
        assertThat(racer.toString()).contains(excepted);
    }

    @DisplayName("전진 테스트")
    @ParameterizedTest(name = "{displayName}: racer: {0}, round: {1}")
    @MethodSource("MoveForwardParametersProvider")
    void checkMoveForward(String value, Integer round, String expected) {
        Accelerator accelerator = new Accelerator(new GeneratorTest.MoveNumberGenerator());
        Racer racer = Racer.of(value);
        for (int i = 0; i < round; i++) {
            racer.play(accelerator);
        }
        Result result = racer.getResult();
        assertThat(result.toIntermediateResult()).contains(expected);
    }

    @DisplayName("전진 하지 못하는 테스트")
    @ParameterizedTest(name = "{displayName}: racer: {0}, round: {1}")
    @MethodSource("CanNotMoveParametersProvider")
    void checkCanNotMove(String value, Integer round, String expected) {
        Accelerator accelerator = new Accelerator(new GeneratorTest.CanNotMoveNumberGenerator());
        Racer racer = Racer.of(value);
        for (int i = 0; i < round; i++) {
            racer.play(accelerator);
        }
        Result result = racer.getResult();
        assertThat(result.toIntermediateResult()).contains(expected);
    }

    static Stream<Arguments> MoveForwardParametersProvider() {
        String line = System.lineSeparator();
        return Stream.of(
                Arguments.arguments("one,two", 2, "one : --" + line + "two : --" + line),
                Arguments.arguments("devil", 4, "devil : ----" + line),
                Arguments.arguments("rest", 0, "rest : " + line)
        );
    }

    static Stream<Arguments> CanNotMoveParametersProvider() {
        String line = System.lineSeparator();
        return Stream.of(
                Arguments.arguments("devil", 10, "devil : " + line),
                Arguments.arguments("1,2,3", 3, "1 : " + line + "2 : " + line + "3 : " + line)
        );
    }
}
