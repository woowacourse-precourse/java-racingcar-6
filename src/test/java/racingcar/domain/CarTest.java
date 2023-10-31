package racingcar.domain;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import racingcar.model.Car;
import racingcar.model.Name;
import racingcar.model.Position;
import racingcar.util.Constants;

public class CarTest {

    @Test
    void 거리_2인_차_결과_출력_테스트() {
        Name name = new Name("가희");
        Car car = init_2_distance_Car(name);

        assertThat(car.positionToString())
                .isEqualTo(name.getName()
                        + Constants.OUTPUT_FORMAT.constant
                        + "--");
    }

    private Car init_2_distance_Car(Name name) {
        Position position = new Position();

        int goDistance = Integer.parseInt(Constants.MINIMUM_DISTANCE_SIZE.constant);
        IntStream.range(0, 2).forEach(i -> position.validatePosition(goDistance));

        return new Car(name, position);
    }

}
