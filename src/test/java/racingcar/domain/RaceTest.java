package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RaceTest {
    Race race = new Race();
    String carNames = "ham,seok,myung";

    @Test
    @DisplayName("No Exception")
    void Race_정상_생성() {
        String attemptCount = "12";
        Assertions.assertThatCode(() -> {
            race.initializeRace(attemptCount, carNames);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    @DisplayName("If Attempt Is Blank, Throw Exception")
    void 시도_회수가_공백일_경우_예외_발생(String attemptCount) {
        Assertions.assertThatThrownBy(() -> race.initializeRace(attemptCount, carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 회수는 공백일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-12", "1.2", "1a2", "0"})
    @DisplayName("If Not Positive Integer, Throw Exception")
    void 시도_회수가_양의_정수가_아닐_경우_예외_발생(String attemptCount) {
        Assertions.assertThatThrownBy(() -> race.initializeRace(attemptCount, carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 회수는 양의 정수만 가능합니다.");
    }

    @Test
    @DisplayName("Single Winner Scenario")
    void 우승자가_1명일_경우() {
        Race race = new Race();
        race.getCars().addCars(
                new Car(new Name("ham"), new Move(new StringBuilder("-"))),
                new Car(new Name("seok"), new Move(new StringBuilder("--"))),
                new Car(new Name("myung"), new Move(new StringBuilder("---")))
        );

        String winners = race.selectWinners();

        Assertions.assertThat(winners).isEqualTo("myung");
    }

    @Test
    @DisplayName("Multiple Winners Scenario")
    void 우승자가_여러명일_경우() {
        Race race = new Race();
        race.getCars().addCars(
                new Car(new Name("ham"), new Move(new StringBuilder(""))),
                new Car(new Name("seok"), new Move(new StringBuilder("---"))),
                new Car(new Name("myung"), new Move(new StringBuilder("---")))
        );

        String winners = race.selectWinners();

        Assertions.assertThat(winners).isEqualTo("seok, myung");
    }
}