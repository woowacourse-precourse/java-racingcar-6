package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceGameTest {

    RaceGame raceGame = new RaceGame();

    @DisplayName("게임을 준비하는 사전작업 기능 테스트")
    @Test
    void setRaceGame() {
        String carNames = "cat,dog,cow";
        String gameRound = "3";

        raceGame.setRaceGame();
    }

    @Test
    void start() {
    }

    @Test
    void gameResult() {
    }
}