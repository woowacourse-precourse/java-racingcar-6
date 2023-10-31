package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.IOTest;
import racingcar.domain.car.carfactory.CarFactory;
import racingcar.domain.car.carfactory.InputCarFactory;
import racingcar.domain.car.validator.InputCarFactoryValidator;

class InputCarFactoryTest extends IOTest {
    @Test
    void 각_자동차에_이름을_입력받아_자동차를_만든다() {
        //given
        CarFactory carFactory = new InputCarFactory(new InputCarFactoryValidator());

        //when
        command("a, b, c");
        List<Car> cars = carFactory.createCars();

        //then
        assertThat(cars.size()).isEqualTo(3);

    }

    @Test
    void 입력받은_자동차_이름이_5글이_이하가_아니라면_에러를_던진다() {
        //given
        CarFactory carFactory = new InputCarFactory(new InputCarFactoryValidator());

        //when
        command("aaaa, bbbb, cccccc");

        //then
        assertThatThrownBy(() -> carFactory.createCars())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 입력받은_자동차_이름에_중복이_발생하면_에러를_던진다() {
        //given
        CarFactory carFactory = new InputCarFactory(new InputCarFactoryValidator());

        //when
        command("a, c, a");

        //then
        assertThatThrownBy(() -> carFactory.createCars())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름에 중복이 있습니다.");
    }

    @Test
    void 입력받은_자동차_이름의_갯수가_최대치를_넘으면_에러를_던진다() {
        //given
        CarFactory carFactory = new InputCarFactory(new InputCarFactoryValidator());

        String carNames = generateNames(CarFactory.MAX_CAR_SIZE + 1);

        //when
        command(carNames);

        //then
        assertThatThrownBy(() -> carFactory.createCars())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차는 최대 " + CarFactory.MAX_CAR_SIZE + "대 만들 수 있습니다.");
    }

    private String generateNames(int size) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=size; i++) sb.append("a" + i + " ");
        String carNames = String.join(",", sb.toString().trim().split(" "));
        return carNames;
    }
}