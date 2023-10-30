package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class CarListTest {

    @Test
    public void 자동차_이름에_중복이_있으면_예외() {
        String input = "a,a,a";

        assertThrows(IllegalArgumentException.class, () -> {
            new CarList(input);
        });
    }

    @Test
    public void split_으로_주어진_자동차_이름을_구분() {
        //given
        String input = "a,b,c";
        //when
        CarList result = new CarList(input);
        //then
        assertThat(result.getCarList()).containsExactly(new Car("a"), new Car("b"), new Car("c"));
    }

}