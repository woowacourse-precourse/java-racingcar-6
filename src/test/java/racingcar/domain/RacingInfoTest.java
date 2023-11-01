package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingInfoTest {

    @Test
    void enter_이름이_5자_이하_체크() {
        //given
        List<String> carNames = List.of("name_more_than_5");
        int turn = 5;

        //when
        //then
        assertThatThrownBy(() -> new RacingInfo(carNames, turn))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되지 않는 5자 이하의 자동차 이름을 입력해주세요.");
    }

    @Test
    void enter_중복_이름_체크() {
        //given
        List<String> carNames = List.of("same_car_name", "same_car_name");
        int turn = 5;

        //when
        //then
        assertThatThrownBy(() -> new RacingInfo(carNames, turn))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되지 않는 5자 이하의 자동차 이름을 입력해주세요.");
    }

    @Test
    void enter_이동_횟수_0이하_체크() {
        //given
        List<String> carNames = List.of("car1", "car2");
        int turn = -1;

        //when
        //then
        assertThatThrownBy(() -> new RacingInfo(carNames, turn))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0보다 큰 회수를 입력해주세요.");
    }
}