package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.utils.Constants;

class CarListTest {


    @Test
    void 자동차_이름_중복_테스트(){
        List<Car> cars = Arrays.asList(
                new Car("중복이름"),
                new Car("중복이름"));

        assertThatThrownBy( () -> new CarList(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_CAR_NAME_DUPLICATION);

    }





}