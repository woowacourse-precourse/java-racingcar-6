package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.math.BigInteger;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Nested
@DisplayName("[Racing Car]")
class RacingCarTest {

    @Test
    @DisplayName("차량 생성 정상 테스트")
    public void carConstructor() {
        assertThat(new RacingCar("car1", new BigInteger("100")))
                .isEqualTo(new RacingCar("car1", new BigInteger("100")));
    }

    @ParameterizedTest
    @MethodSource("invalidCarNames")
    @DisplayName("차량 생성 예외 테스트 : 잘못된 차량 이름 입력")
    public void exceptCarConstructor(final String name) {
        assertThrows(IllegalArgumentException.class,
                () -> new RacingCar(name, new BigInteger("10")));
    }

    static Stream<Arguments> invalidCarNames() {
        return Stream.of(
                arguments(""),
                arguments("   "),
                arguments("자동차222"),
                arguments((Object) null)
        );
    }

}