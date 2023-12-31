package racingcar.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.repository.Track;

public class TrackTest {

    Track track = new Track();
    @Test
    void 경주_차량_개수_검사_테스트() {
        List<Car> input = List.of(new Car("name"));
        Cars cars = new Cars(input);

        Assertions.assertThatThrownBy(() -> track.ready(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
