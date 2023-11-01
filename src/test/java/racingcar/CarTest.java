package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.repository.Car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest extends NsTest {

    @Test
    void 이름을_정해주고_가져올수있다() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 이름길이제한은_5글자이하이다() {
        Car car = new Car("");
        assertThat(car.getName()).isEqualTo("");

        Car car2 = new Car("a");
        assertThat(car2.getName()).isEqualTo("a");

        Car car3 = new Car("bb");
        assertThat(car3.getName()).isEqualTo("bb");

        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Car("asdfasdfasdfasdfdasfasdfadsfasdfasdfadsfasdfasdf"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차는_이동할수있다() {
        Car car = new Car("pobi");
        car.move(1);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차는_이동거리_제한이없다() {
        Car car = new Car("pobi");
        car.move(6);
        assertThat(car.getPosition()).isEqualTo(6);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
