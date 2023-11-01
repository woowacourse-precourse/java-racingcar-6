package racingcar.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.model.Racer;

class RaceRefereeTest {

    @Test
    void 전진일_때_movewState에_변화_확인() {
        // Given
        Racer testRacer = new Racer("testRacer");

        // When
        testRacer.goState();
        testRacer = RaceReferee.increaseGoMark(testRacer);

        // Then
        assertThat(testRacer.moveState).isEqualTo("-");
    }
}