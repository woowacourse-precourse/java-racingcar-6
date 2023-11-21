package racingcar.domain.car;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.numbergenerator.ListNumberGenerator;
import racingcar.domain.numbergenerator.RandomNumberGenerator;
import racingcar.exception.RacingException;

class CarsTest {

    @Nested
    @DisplayName("Cars 생성 테스트")
    class 생성_테스트 {
        @ParameterizedTest(name = "{0}를 입력하면 정상적으로 객체가 생성된다.")
        @MethodSource("getNames")
        @DisplayName("[SUCCESS] 객체 정상 생성 테스트")
        void 정상_생성_테스트(List<String> names) {
            Assertions.assertThatNoException()
                    .isThrownBy(() -> new Cars(names, new RandomNumberGenerator()));
        }

        static Stream<List<String>> getNames() {
            return Stream.of(
                    List.of("pobi", "hi", "name"),
                    List.of("pobi"),
                    List.of("hi", "name")
            );
        }

        @ParameterizedTest(name = "{0}를 입력하면 예외가 발생한다.")
        @MethodSource("getDuplicatedNames")
        @DisplayName("[EXCEPTION] 중복된 이름 예외 테스트")
        void 중복_이름_테스트(List<String> names) {
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Cars(names, new RandomNumberGenerator()))
                    .withMessage(RacingException.DUPLICATE_CARS_NAME.getMessage());
        }

        static Stream<List<String>> getDuplicatedNames() {
            return Stream.of(
                    List.of(
                            "pobi", "pobi"
                    )
            );
        }
    }

    @Nested
    @DisplayName("우승자 테스트")
    class 우승자_테스트 {

        @ParameterizedTest(name = "{2} 우승")
        @MethodSource("carsAndResult")
        @DisplayName("[SUCCESS] 우승자가 정상적으로 반환된다.")
        void 우승자_성공_테스트(Cars cars, int roundNumber, String[] expectedResult) {
            for (int round = 0; round < roundNumber; round++) {
                cars.move();
            }
            Assertions.assertThat(cars.getWinner())
                    .containsExactly(expectedResult);
        }

        static Stream<Arguments> carsAndResult() {
            return Stream.of(
                    Arguments.of(
                            new Cars(
                                    List.of("1", "2", "3"),
                                    new ListNumberGenerator(List.of(
                                            4, 4, 3,
                                            3, 4, 4,
                                            4, 4, 4,
                                            4, 3, 3,
                                            4, 4, 3
                                    ))
                            ), 5,
                            new String[]{"1", "2"}
                    ),
                    Arguments.of(
                            new Cars(
                                    List.of("1", "2", "3"),
                                    new ListNumberGenerator(List.of(
                                            4, 4, 3,
                                            3, 4, 4,
                                            4, 4, 4,
                                            4, 3, 3,
                                            4, 3, 3
                                    ))
                            ), 5,
                            new String[]{"1"}
                    ),
                    Arguments.of(
                            new Cars(
                                    List.of("1", "2", "3"),
                                    new ListNumberGenerator(List.of(
                                            4, 4, 3,
                                            3, 4, 4,
                                            4, 4, 4,
                                            4, 3, 4,
                                            4, 4, 4
                                    ))
                            ), 5,
                            new String[]{"1", "2", "3"}
                    )
            );
        }
    }

}