package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RaceTest {

    @Nested
    @DisplayName("Car 생성: ")
    class createCarsBy {
        @Test
        @DisplayName("올바른 입력")
        void validInput() {
            String input = "name";

            Race race = new Race(input);

            assertThat(race.getCars().isEmpty()).isFalse();
        }

        @Test
        @DisplayName("한 명도 존재하지 않는 입력")
        void NoOneExistInput() {
            String input = ",,";

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

        List<String> raceResult = race.findWinners();

        assertThat(raceResult.isEmpty()).isFalse();
    }
}