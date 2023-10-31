package racingcarv2;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcarv2.model.Name;

public class NameTest {
    @Test
    void Name_생성() {
        Name pobi = new Name("pobi");
        Assertions.assertThat(pobi.getNameValue()).isEqualTo("pobi");
    }

    private static Stream<Arguments> generateValidNames() {
        return Stream.of(
                Arguments.of("pobix,hobix,linix"),
                Arguments.of("p,h,l"),
                Arguments.of("pp,hh,ll")
        );
    }


    @ParameterizedTest
    @MethodSource("generateValidNames")
    void 조건에_맞는_이름_성공(String validName) {
        Assertions.assertThatNoException().isThrownBy(
                () -> new Name(validName)
        );
    }

    private static Stream<Arguments> generateUnvalidNames() {
        return Stream.of(
                Arguments.of("sung,sung,hyeri"),
                Arguments.of("sungki,pobili"),
                Arguments.of("abcdef,ghiklmnop,qrstuv")
        );
    }

    @ParameterizedTest
    @MethodSource("generateUnvalidNames")
    void 조건에_맞지_않는_이름_예외(String unvalidName) {
        Assertions.assertThatThrownBy(() -> new Name(unvalidName))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
