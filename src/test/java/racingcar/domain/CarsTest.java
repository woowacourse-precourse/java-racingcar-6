package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.UserInputException;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private Cars cars;

    @BeforeEach
    public void beforeEach() {
        cars = new Cars(List.of(new Car("kim"), new Car("lee")));
    }

    @Test
    @DisplayName("우승자 이름 찾기")
    public void getWinnerNames_메서드로_우승자_이름을_찾는다() throws Exception {
        assertRandomNumberInRangeTest(
                () -> {
                    cars.move();
                    assertThat(cars.getWinnerNames()).contains("kim");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("공동 우승시 우승자 이름 모두 반환")
    public void getWinnerNames_메서드_사용시_공동_우승시_우승자_이름을_모두_반환한다() throws Exception {
        assertRandomNumberInRangeTest(
                () -> {
                    cars.move();
                    assertThat(cars.getWinnerNames()).contains("kim", "lee");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("중복 이름시 예외 발생")
    public void validateDuplicate_중복_이름시_예외가_발생한다() throws Exception {
        assertThrows(
                UserInputException.class, () -> new Cars(List.of(new Car("kim"), new Car("kim")))
        );
    }
}