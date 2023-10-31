package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LocationTest {

    private final Location location = Location.init();

    @Test
    void 위치_이동시_랜덤한_값에_따라_0_혹은_1씩_움직인다() {
        Location moved = location.move();
        int currentLocationValue = moved.location();
        assertThat(currentLocationValue).isBetween(0, 1);
    }
}