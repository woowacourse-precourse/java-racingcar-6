package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LocationTest {
    @Test
    void 위치값을_비교후_최대값인지_확인한다(){
        Location location = new Location(4);
        Location maxLocation = new Location(5);

        assertFalse(location.isMax(maxLocation));
    }
}