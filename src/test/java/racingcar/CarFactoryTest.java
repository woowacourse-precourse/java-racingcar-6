package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarFactoryTest {
    @Test
    void 자동차_이름이_5자_이하이면_자동차_리스트에_자동차_객체_저장() {
        List<String> names = List.of("aaaaa", "bbbb", "ccc");
        CarFactory carFactory = new CarFactory();

        List<Car> carList = carFactory.createCars(names);

        assertThat(carList.size()).isEqualTo(3);
        assertThat(carList.get(0).getName()).isEqualTo("aaaaa");
        assertThat(carList.get(1).getName()).isEqualTo("bbbb");
        assertThat(carList.get(2).getName()).isEqualTo("ccc");
    }

    @Test
    void 자동차_이름이_5자를_넘으면_예외발생() {
        String names = "이름이여섯자";
        CarFactory carFactory = new CarFactory();
        assertThatThrownBy(() -> carFactory.validateName(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하만 가능합니다.");
    }
}