package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

class CarsTest {

    private static final String inputCarNames = "pobi,ruby,dobbi";

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
        Cars list = new Cars(inputCarNames);
        assertThatThrownBy(() -> list.getCars().add(new Car("pobi")))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("랜덤 수를 비교해서 전진, 스탑을 판단하고 distance를 update한다.")
    void testUpdateDistance() {
        Cars cars = new Cars(inputCarNames);
        NumberGenerator ng = new RandomNumberGenerator();
        List<Integer> pickNumbers = IntStream.range(0, cars.carsSize())
                .mapToObj(item -> ng.pickNumber()).toList();
        cars.updateDistance(pickNumbers);

        int maxPickNumber = Collections.max(pickNumbers);
        boolean expected = maxPickNumber >= 4;
        int result = expected ? 1 : 0;

        assertThat(result).isEqualTo(cars.maxDistance());
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