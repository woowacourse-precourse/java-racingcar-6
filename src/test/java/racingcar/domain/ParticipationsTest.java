package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.racing.car.Car;
import racingcar.domain.racing.Participations;

public class ParticipationsTest {

    @Test
    public void 자동차이름들_미입력시_예외발생() {
        // given
        String carNames = "";

        // when && then
        assertThatThrownBy(() -> Participations.create(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 하나 이상 입력하세요.");
    }

    @Test
    public void 자동차이름들_공백입력시_예외발생() {
        // given
        String carNames = " ";

        // when && then
        assertThatThrownBy(() -> Participations.create(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 하나 이상 입력하세요.");
    }

    @Test
    public void 자동차이름들_콤마만_입력시_예외발생() {
        // given
        String carNames = ", , ,,";

        // when && then
        assertThatThrownBy(() -> Participations.create(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 하나 이상 입력하세요.");
    }

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
