package racingcar.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Cars cars = Cars.from(List.of("pobi", "lee"));

        assertThat(cars.describeAll().size()).isEqualTo(2);
    }

    @DisplayName("알 수 없는 이름 목록(null)으로 객체를 생성할 수 없다.")
    @Test
    void createWithNull() {
        assertThatThrownBy(() -> Cars.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 목록입니다.");
    }

    @DisplayName("적어도 하나의 자동차가 필요하다.")
    @Test
    void checkSize() {
        assertThatThrownBy(() -> Cars.from(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("적어도 하나의 이름이 필요합니다.");
    }

    @DisplayName("중복된 이름은 허용되지 않는다.")
    @Test
    void createWithDuplication() {
        assertThatThrownBy(() -> Cars.from(List.of("lee", "pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름은 허용되지 않습니다.");
    }

    @DisplayName("모든 자동차를 이동할 수 있다.")
    @Test
    void moveAll() {
        Cars cars = Cars.from(List.of("pobi", "lee"));

        cars.moveAll(() -> true);

        List<CarDescription> result = cars.describeAll();
        assertThat(result)
                .hasSize(2)
                .containsExactly(
                        new CarDescription("pobi", 1),
                        new CarDescription("lee", 1)
                );
    }

    @DisplayName("선두의 이름을 조회할 수 있다.")
    @Test
    void frontCar() {
        Cars cars = Cars.from(List.of("pobi", "lee"));
        cars.moveAll(moveFirstCarPolicy(new AtomicBoolean(true)));

        List<String> result = cars.findFrontCarsName();

        assertThat(result)
                .hasSize(1)
                .containsExactly("pobi");
    }

    @DisplayName("선두는 여러명이 될 수 있다.")
    @Test
    void frontCars() {
        Cars cars = Cars.from(List.of("pobi", "lee"));
        cars.moveAll(() -> true);

        List<String> result = cars.findFrontCarsName();

        assertThat(result)
                .hasSize(2)
                .containsExactly("pobi", "lee");
    }

    private MovePolicy moveFirstCarPolicy(AtomicBoolean isFirst) {
        return () -> {
            if (isFirst.get()) {
                isFirst.set(false);
                return true;
            }

            return false;
        };
    }
}
