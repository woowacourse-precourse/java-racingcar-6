package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AcceleratorTest {

    @DisplayName("이동 가능하다면 True, 이동 불가하다면 False 반환 테스트")
    @ParameterizedTest(name = "{displayName}")
    @MethodSource("parametersProvider")
    void checkCanMoveForward(NumberGenerator numberGenerator, boolean expected) {
        Accelerator accelerator = new Accelerator(numberGenerator);
        assertThat(accelerator.canMoveForward()).isEqualTo(expected);
    }

    static Stream<Arguments> parametersProvider() {
        return Stream.of(
                Arguments.of(new GeneratorTest.MoveNumberGenerator(), true),
                Arguments.of(new GeneratorTest.CanNotMoveNumberGenerator(), false));
    }
}