package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.dto.RaceResult;

class RaceTest {

    @Nested
    @DisplayName("시도할 횟수만큼 Car 생성: ")
    class createCarsBy {
        @Test
        @DisplayName("올바른 입력")
        void validInput() {
            String input = "5";

            Race race = new Race(input);

            assertThat(race.getCars().size()).isEqualTo(Integer.parseInt(input));
        }

        @Test
        @DisplayName("숫자가 아닌 입력")
        void notNumberInput() {
            String input = "5";

            assertThrows(IllegalArgumentException.class, () -> new Race(input));
        }
    }

    @Test
    @DisplayName("모든 자동차들을 전진 시킨다")
    void moveCars() {
        Race race = new Race("5");

        race.moveCars();

        assertThat(race).isNotNull();
    }

    @Test
    @DisplayName("우승자 목록을 반환한다")
    void findWinners() {
        Race race = new Race("5");

        RaceResult raceResult = race.findWinners();

        assertThat(raceResult).isNotNull();
    }
}