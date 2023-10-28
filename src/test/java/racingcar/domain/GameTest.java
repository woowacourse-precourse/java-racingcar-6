package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.NumberGenerator;

@DisplayName("Game 단위 테스")
class GameTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = Cars.from(List.of("pobi", "woni", "jun"));
    }

    @DisplayName("시도 횟수가 1미만일 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void throw_exception_when_invalid_number_of_attempts(int input) {
        // given
        NumberGenerator numberGenerator = new TestNumberGenerator(List.of(1, 2, 3));

        // when & then
        assertThatThrownBy(() -> new Game(numberGenerator, cars, input));
    }

    @DisplayName("시도 횟수만큼 결과를 저장한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 999})
    void save_results(int input) {
        // given
        NumberGenerator numberGenerator = new TestNumberGenerator(List.of(1, 2, 3));
        Game game = new Game(numberGenerator, cars, input);

        // when
        game.moveCars();
        List<RoundResult> results = game.getResults();

        // then
        assertThat(results.size()).isEqualTo(input);
    }

    @DisplayName("우승자가 1명일 때 정확한 결과를 리턴한다.")
    @Test
    void return_1_winner() {
        // given
        Game game = new Game(
                new TestNumberGenerator(List.of(1, 1, 4)),
                cars,
                1
        );

        // when
        game.moveCars();
        List<String> winners = game.getWinner();
        String winnerJun = winners.get(0);

        // then
        assertAll(
                () -> assertThat(winners.size()).isEqualTo(1),
                () -> assertThat(winnerJun).isEqualTo("jun")
        );
    }

    @DisplayName("우승자가 여러명일 때 정확한 결과를 리턴한다.")
    @Test
    void return_many_winner() {
        // given
        Game game = new Game(
                new TestNumberGenerator(List.of(4, 1, 4)),
                cars,
                1
        );

        // when
        game.moveCars();
        List<String> winners = game.getWinner();
        String winnerPobi = winners.get(0);
        String winnerJun = winners.get(1);

        // then
        assertAll(
                () -> assertThat(winners.size()).isEqualTo(2),
                () -> assertThat(winnerPobi).isEqualTo("pobi"),
                () -> assertThat(winnerJun).isEqualTo("jun")
        );
    }

    public static class TestNumberGenerator implements NumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public List<Integer> generate(int size) {
            return numbers;
        }
    }
}
