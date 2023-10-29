package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    Car car;

    @BeforeEach
    void beforeEach(){
        car = new Car("toto");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 랜덤변수_3이하(int randNum){
        // when
        car.move(randNum);

        // then
        Assertions.assertThat(car.getDistance()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void 랜덤변수_4이상(int randNum){
        // when
        car.move(randNum);

        // then
        Assertions.assertThat(car.getDistance()).isEqualTo(1);
    }
}