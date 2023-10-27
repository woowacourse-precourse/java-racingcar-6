package racingcar.domain;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        List<Car> source = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        cars = new Cars(source);
    }

    @Test
    @DisplayName("경주에 참여할 자동차들의 정보를 알 수 있다.")
    void createCars() {
        assertThat(cars).extracting("cars", InstanceOfAssertFactories.list(Car.class))
                .containsExactly(new Car("pobi"), new Car("woni"), new Car("jun"));
    }

    @Test
    @DisplayName("경주에 참여할 자동차가 없다면 예외가 발생한다.")
    void invalidCars() {
        assertThatThrownBy(() -> new Cars(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주에 참여할 자동차는 최소 1대 이상이어야 합니다.");
    }

    @Test
    @DisplayName("경주에 참여하는 자동차의 이름 중 중복되는 이름이 있다면 예외가 발생한다.")
    void hasDuplicatedName() {
        assertThatThrownBy(() -> new Cars(List.of(new Car("pobi"), new Car("pobi"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주에 참여하는 자동차들의 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("경주에 참여하는 자동차들을 전진시킬 수 있다.")
    void move() {
        cars.makeMoveOrStop(() -> 4);

        assertThat(cars).extracting("cars", InstanceOfAssertFactories.list(Car.class))
                .containsExactly(
                        new Car("pobi", 1),
                        new Car("woni", 1),
                        new Car("jun", 1));
    }

    @Test
    @DisplayName("경주에 참여하는 자동차들을 정지시킬 수 있다.")
    void stop() {
        cars.makeMoveOrStop(() -> 3);

        assertThat(cars).extracting("cars", InstanceOfAssertFactories.list(Car.class))
                .containsExactly(
                        new Car("pobi", 0),
                        new Car("woni", 0),
                        new Car("jun", 0));
    }

    @Test
    @DisplayName("경주에 참여하는 자동차들 중 가장 많이 전진한 자동차를 알 수 있다.")
    void findMostMovedCars() {
        List<Car> source = List.of(
                new Car("pobi", 2),
                new Car("woni", 1),
                new Car("jun", 2));
        Cars cars = new Cars(source);

        List<Car> result = cars.findMostMovedCars();

        assertThat(result).containsExactly(new Car("pobi", 2), new Car("jun", 2));
    }
}