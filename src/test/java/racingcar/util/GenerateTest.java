package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.AttemptCount;
import domain.Car;
import domain.Cars;
import domain.MoveCount;
import domain.Name;


public class GenerateTest {
    @Test
    @DisplayName("AttemptCount 생성 성공")
    void create_attempt_count_success() {
        AttemptCount attemptCount = new AttemptCount("5");
        assertThat(attemptCount).isNotNull();
    }

    @Test
    @DisplayName("MoveCount 생성 성공")
    void create_move_count_success() {
        MoveCount moveCount = new MoveCount(1);
        assertThat(moveCount).isNotNull();
    }

    @Test
    @DisplayName("Name 생성 성공")
    void create_name_success() {
        Name name = new Name("hello");
        assertThat(name).isNotNull();
    }

    @Test
    @DisplayName("Car 생성 성공")
    void create_car_success() {
        Car car = new Car("abc");
        assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("Cars 생성 성공")
    void create_cars_success() {
        Cars cars = new Cars("ab,cd");
        assertThat(cars).isNotNull();
    }
}
