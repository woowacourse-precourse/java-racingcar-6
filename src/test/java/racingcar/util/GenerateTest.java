package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import domain.AttemptCount;
import domain.Car;
import domain.Cars;
import domain.MoveCount;
import domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class GenerateTest {
    private static final String MOVING_FOWARD = "4";
    private static final String TEMPORARY_NAME = "abc";
    private static final String TEMPORARY_NAME_LIST = "abc,def";

    @Test
    @DisplayName("AttemptCount 생성 성공")
    void create_attempt_count_success() {
        AttemptCount attemptCount = new AttemptCount(MOVING_FOWARD);
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
        Name name = new Name(TEMPORARY_NAME);
        assertThat(name).isNotNull();
    }

    @Test
    @DisplayName("Car 생성 성공")
    void create_car_success() {
        Car car = new Car(TEMPORARY_NAME);
        assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("Cars 생성 성공")
    void create_cars_success() {
        Cars cars = new Cars(TEMPORARY_NAME_LIST);
        assertThat(cars).isNotNull();
    }
}
