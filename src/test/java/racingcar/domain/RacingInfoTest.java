package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.type.ErrorCode.CAR_NAME_IS_NOT_DUPLICATE_AND_LESS_THAN_5;
import static racingcar.type.ErrorCode.TURN_IS_MORE_THAN_ZERO;

class RacingInfoTest {
    static final List<String> CAR_NAME_IS_MORE_THAN_5 = List.of("name_more_than_5");
    static final List<String> DUPLICATE_NAME_CARS = List.of("same_car_name", "same_car_name");
    static final List<String> NORMAL_CARS = List.of("car1", "car2");
    static final int NORMAL_TURN = 5;
    static final int INVALID_TURN = -1;

    @Test
    void enter_이름이_5자_이하_체크() {
        //when
        //then
        assertThatThrownBy(() -> new RacingInfo(CAR_NAME_IS_MORE_THAN_5, NORMAL_TURN))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_IS_NOT_DUPLICATE_AND_LESS_THAN_5.getMessage());
    }

    @Test
    void enter_중복_이름_체크() {
        //when
        //then
        assertThatThrownBy(() -> new RacingInfo(DUPLICATE_NAME_CARS, NORMAL_TURN))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_IS_NOT_DUPLICATE_AND_LESS_THAN_5.getMessage());
    }

    @Test
    void enter_이동_횟수_0이하_체크() {
        //when
        //then
        assertThatThrownBy(() -> new RacingInfo(NORMAL_CARS, INVALID_TURN))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TURN_IS_MORE_THAN_ZERO.getMessage());
    }
}