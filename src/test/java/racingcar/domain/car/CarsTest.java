package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.random.RandomNumberGenerator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @DisplayName("자동차 이름 리스트가 주어진 경우 인스턴스를 생성한다.")
    @Test
    void givenNameList_WhenNew_ThenReturnInstance() {
        // Given
        List<String> names = List.of("자동차1", "자동차2", "자동차3");

        // When
        Cars actual = Cars.createFromNames(names);

        // Then
        assertEquals(Cars.createFromNames(names), actual);
    }

    @DisplayName("자동차 이름 리스트가 빈 배열인 경우 예외를 발생한다.")
    @Test
    void givenEmptyList_WhenNew_ThenThrowException() {
        // Given
        List<String> names = List.of();

        // When
        // Then
        assertThatThrownBy(() -> Cars.createFromNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 배열일 수 없습니다.");
    }

    @DisplayName("정해진 값에 따라 자동차 경주를 진행한 후 현재 상태를 반환한다.")
    @Test
    void givenNumberList_WhenRace_ThenReturnCurrentStatus() {
        // Given
        List<String> names = List.of("car1", "car2");
        Cars cars = Cars.createFromNames(names);

        // When
        cars.race(MockRandomNumberGenerator.setNumbers(5, 2));
        List<CarDto> status = cars.getStatus();

        // Then
        assertAll(
                () -> assertEquals(2, status.size()),
                () -> assertEquals(1, status.get(0).position()),
                () -> assertEquals("car1", status.get(0).name()),
                () -> assertEquals(0, status.get(1).position()),
                () -> assertEquals("car2", status.get(1).name())
        );
    }

    @DisplayName("정해진 값에 따라 자동차 경주를 진행한 후 한명의 승자를 반환한다.")
    @Test
    void givenNumberList_WhenRace_ThenFirstCarIsWinner() {
        // Given
        List<String> names = List.of("win", "lose");
        Cars cars = Cars.createFromNames(names);

        // When
        cars.race(MockRandomNumberGenerator.setNumbers(5, 2));
        List<String> topCarNames = cars.findTopCarNames();

        // Then
        assertAll(
                () -> assertFalse(topCarNames.isEmpty()),
                () -> assertEquals(1, topCarNames.size()),
                () -> assertEquals("win", topCarNames.get(0))
        );
    }

    @DisplayName("정해진 값에 따라 자동차 경주를 진행한 후 여러명의 승자를 반환한다")
    @Test
    void givenNumberList_WhenRace_ThenAllCarIsWinner() {
        // Given
        List<String> names = List.of("car1", "car2");
        Cars cars = Cars.createFromNames(names);

        // When
        cars.race(MockRandomNumberGenerator.setNumbers(5, 5));
        List<String> topCarNames = cars.findTopCarNames();

        // Then
        assertAll(
                () -> assertFalse(topCarNames.isEmpty()),
                () -> assertEquals(2, topCarNames.size()),
                () -> assertEquals(names, topCarNames)
        );
    }

    static class MockRandomNumberGenerator implements RandomNumberGenerator {

        private final Queue<Integer> numbers;

        private MockRandomNumberGenerator(Queue<Integer> numbers) {
            this.numbers = numbers;
        }

        public static RandomNumberGenerator setNumbers(int... numbers) {
            Queue<Integer> queue = new LinkedList<>();
            for (int number : numbers) {
                queue.add(number);
            }
            return new MockRandomNumberGenerator(queue);
        }

        @Override
        public int getRandomNumber() {
            if (!numbers.isEmpty()) {
                return numbers.remove();
            }
            throw new IllegalArgumentException("숫자가 더이상 존재하지 않음");
        }
    }
}