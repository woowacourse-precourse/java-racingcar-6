package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 이름_길이_초과_테스트() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Car.MAX_NAME_LENGTH + 1; i++) {
            sb.append("a");
        }
        String name = sb.toString();

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_공백_테스트() {
        String name = "";

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_NULL_테스트() {
        String name = null;

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_정상_테스트() {
        String name = "cname";
        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo("cname");
    }

    @Test
    void 이동_횟수_초기화_테스트() {
        Car car = new Car("name");
        int moveCount = car.getMoveCount();

        assertThat(moveCount).isEqualTo(0);
    }
}
