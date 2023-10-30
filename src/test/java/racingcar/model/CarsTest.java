package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {

    @DisplayName("중복된 Car 객체는 예외를 발생시킨다.")
    @ParameterizedTest
    @MethodSource("inputCarNames")
    void testDuplicatedCarException(String inputCarNames) {
        assertThatThrownBy(() -> new Cars(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Car 리스트는 수정하지 못한다.")
    void testModifyCarList() {
        String inputCarNames = "not,modi";
        Cars list = new Cars(inputCarNames);
        assertThatThrownBy(() -> list.getCars().add(new Car("pobi")))
                .isInstanceOf(UnsupportedOperationException.class);
    }
    static Stream<Arguments> inputCarNames() {
        return Stream.of(
                Arguments.arguments("bobi,hi,hi"),
                Arguments.arguments("hi,bye,pobi,pobi"),
                Arguments.arguments("hii,bye,bye"),
                Arguments.arguments("a,b,c,d,e,f,g,e,f,g,pobi,h,i,pobi"),
                Arguments.arguments("bobi, hi, hi"),
                Arguments.arguments("hi, bye, pobi, pobi"),
                Arguments.arguments("hii, bye, bye"),
                Arguments.arguments("a, b, c, d, e, f, g, e, f, g, pobi, h, i, pobi")
        );
    }

}