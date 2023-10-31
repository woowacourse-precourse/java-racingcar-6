package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.generator.NumberGenerator;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class RaceTest {

    private static class MockRandomNumberGenerator implements NumberGenerator {
        private final List<Integer> numbers;
        private int index = 0;

        public MockRandomNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.get(index++);
        }
    }

    @DisplayName("레이싱에 참가한 자동차들이 4 이상인 경우 전진하고 3 이하일 때 멈췄는 지 확인한다.")
    @ParameterizedTest(name = "{index} : 레이싱에 참가한 자동차가 {0}을 받으면 위치는 {2}, {1}을 받으면 위치는 {3}이다.")
    @CsvSource(value = {"1, 2, 0, 0", "2, 3, 0, 0", "3, 4, 0, 1", "4, 5, 1, 1", "1, 9, 0, 1"})
    void raceProcessTest(int first, int second, int pos1, int pos2) {
        //given
        MockRandomNumberGenerator mockRandomNumberGenerator = new MockRandomNumberGenerator(List.of(first, second));
        Race race = new Race(List.of("poby", "woni"), mockRandomNumberGenerator);
        //when
        race.process();
        //then
        assertThat(race.getCars())
                .extracting("position")
                .containsExactly(pos1, pos2);
    }

    @DisplayName("우승자를 확인한다.")
    @ParameterizedTest(name = "{index} : 숫자가 {0}, 레이싱에 참가한 자동차 이름이 {1}이면 우승자는 {2}이다.")
    @MethodSource("raceWinnerTestSource")
    void raceWinnerTest(List<Integer> numbers, List<String> carNames, List<String> expected) {
        //given
        MockRandomNumberGenerator mockRandomNumberGenerator = new MockRandomNumberGenerator(numbers);
        Race race = new Race(carNames, mockRandomNumberGenerator);
        //when
        race.process();
        List<String> winners = race.winners();
        //then
        assertThat(winners).containsExactlyElementsOf(expected);
    }

    static Stream<Arguments> raceWinnerTestSource() {
        return Stream.of(
                Arguments.of(List.of(1, 2), List.of("poby","woni"), List.of("poby", "woni")),
                Arguments.of(List.of(3, 4), List.of("poby","woni"), List.of("woni")),
                Arguments.of(List.of(4, 4), List.of("poby","woni"), List.of("poby", "woni")),
                Arguments.of(List.of(3, 3), List.of("poby","woni"), List.of("poby", "woni")),
                Arguments.of(List.of(9, 1), List.of("poby","woni"), List.of("poby"))
        );
    }

}