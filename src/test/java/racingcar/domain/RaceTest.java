package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("If Attempt Is Blank, Throw Exception")
    void 시도_회수가_공백일_경우_예외_발생() {
        String attemptCount1 = "";
        Assertions.assertThatThrownBy(() -> race.initializeRace(attemptCount1, carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 회수는 공백일 수 없습니다.");

        String attemptCount2 = "   ";
        Assertions.assertThatThrownBy(() -> race.initializeRace(attemptCount2, carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 회수는 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("If Not Positive Integer, Throw Exception")
    void 시도_회수가_양의_정수가_아닐_경우_예외_발생() {
        String attemptCount1 = "-12";
        Assertions.assertThatThrownBy(() -> race.initializeRace(attemptCount1, carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 회수는 양의 정수만 가능합니다.");

        String attemptCount2 = "1.2";
        Assertions.assertThatThrownBy(() -> race.initializeRace(attemptCount2, carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 회수는 양의 정수만 가능합니다.");

        String attemptCount3 = "1a2";
        Assertions.assertThatThrownBy(() -> race.initializeRace(attemptCount3, carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 회수는 양의 정수만 가능합니다.");

        String attemptCount4 = "0";
        Assertions.assertThatThrownBy(() -> race.initializeRace(attemptCount4, carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 회수는 양의 정수만 가능합니다.");
    }
}