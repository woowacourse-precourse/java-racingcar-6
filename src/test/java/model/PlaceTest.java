package model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PlaceTest {
    @Test
    public void 전진_테스트(){
        Place place = new Place();
        place.moveForward();
        assertThat(place.getMoveCount()).isEqualTo(1);
    }
}
