package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Car;
import domain.CarFactory;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.support.StubCarEngine;

public class CarFactoryTest {

    @Test
    void generateCars는_차_이름을_통해_자동차를_생성한다() {
        // given
        final String 첫번째_차_이름 = "차_이름1";
        final String 두번째_차_이름 = "차_이름2";
        final CarFactory carFactory = new CarFactory(new StubCarEngine());

        // when
        final List<Car> cars = carFactory.generateCars(List.of(첫번째_차_이름, 두번째_차_이름));

        // then
        final List<String> 차_이름 = cars.stream().map(Car::getName).toList();
        assertThat(차_이름).containsExactlyInAnyOrder(첫번째_차_이름, 두번째_차_이름);
    }


    @Test
    void 중복된_이름이_있다면_예외를_던진다() {
        // given
        final String 첫번째_차_이름 = "차_이름1";
        final String 두번째_차_이름 = "차_이름1";
        final CarFactory carFactory = new CarFactory(new StubCarEngine());

        // when & then
        assertThatThrownBy(() -> carFactory.generateCars(List.of(첫번째_차_이름, 두번째_차_이름)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
