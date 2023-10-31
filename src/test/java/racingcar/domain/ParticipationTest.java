package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParticipationTest {

    @Test
    public void 중복된_이름의_Car객체저장() {
        // given
        String name = "car1";
        final Car car1 = Car.create(name);
        final Car car2 = Car.create(name);

        List<Car> carList = new ArrayList<>() {{
            add(car1);
            add(car2);
        }};

        // when && then
        Assertions.assertThatThrownBy(() -> Participations.create(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름은 입력할 수 없습니다.");
    }

}
