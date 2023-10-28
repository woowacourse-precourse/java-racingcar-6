package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.IOTest;

class InputCarFactoryTest extends IOTest {
    @Test
    void 각_자동차에_이름을_입력받아_자동차를_만든다() {
        //given
        CarFactory carFactory = new InputCarFactory();

        //when
        command("a, b, c");
        List<Car> cars = carFactory.createCars();

        //then
        assertThat(cars.size()).isEqualTo(3);

    }

    @Test
    void 입력받은_자동차_이름이_5글이_이하가_아니라면_에러를_던진다() {
        //given
        CarFactory carFactory = new InputCarFactory();

        //when
        command("aaaa, bbbb, cccccc");

        //then
        assertThatThrownBy(() -> carFactory.createCars())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }
}