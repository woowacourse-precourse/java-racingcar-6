package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    Car car;

    @BeforeEach
    public void beforeEach() {
        car = new Car("pobi");
    }

    @Test
    void advanceIfRandomIsAtLeastFour_랜덤숫자가_4이상일_경우() {
        //given
        Integer randomNum = 5;
        //when
        car.advanceIfRandomIsAtLeastFour(randomNum);
        //then
        assertThat(car.getAdvanceCount()).isEqualTo(1);
    }

    @Test
    void advanceIfRandomIsAtLeastFour_랜덤숫자가_4미만일_경우() {
        //given
        Integer randomNum = 3;
        //when
        car.advanceIfRandomIsAtLeastFour(randomNum);
        //then
        assertThat(car.getAdvanceCount()).isEqualTo(0);
    }
}