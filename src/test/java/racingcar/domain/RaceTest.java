package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {

    @Test
    void 랜덤_숫자의_범위가_0에서_9사이임을_테스트한다() {
        Race race = new Race("3");
        int min = Race.RANDOM_MIN_NUMBER;
        int max = Race.RANDOM_MAX_NUMBER;

        int randomNumber = race.pickRandomNumber();

        assertTrue(randomNumber >= min && randomNumber <= max);
    }
    @Test
    void 시도_횟수_도달_테스트() {
        Race race = new Race("3");
        race.increaseCurrentTrial();

        assertFalse(race.currentTrialReachedTotal());
        race.increaseCurrentTrial();
        assertFalse(race.currentTrialReachedTotal());
        race.increaseCurrentTrial();
        assertTrue(race.currentTrialReachedTotal());
    }

    @Test
    void trialNumber이_자연수가_아니면_에러를_던진다() {
        String trialNumber = "1.4";

        assertThrows(IllegalArgumentException.class, () -> {
            new Race(trialNumber);
        });
    }

    @Test
    void trialNumber이_null이면_에러를_던진다() {
        String trialNumber = null;

        assertThrows(IllegalArgumentException.class, () -> {
            new Race(trialNumber);
        });
    }

    @Test
    void trialNumber이_공백이면_에러를_던진다() {
        String trialNumber = "";

        assertThrows(IllegalArgumentException.class, () -> {
            new Race(trialNumber);
        });
    }

    @Test
    void trialNumber이_whitespace이면_에러를_던진다() {
        String trialNumber = " 9";

        assertThrows(IllegalArgumentException.class, () -> {
            new Race(trialNumber);
        });
    }

}