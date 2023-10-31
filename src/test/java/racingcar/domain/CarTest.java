package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import racingcar.constants.DomainConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("tiger");
    }

    @Test
    @DisplayName("자동차 이름 반환 테스트")
    void testGetCarName() {
        assertThat(car.getName()).isEqualTo("tiger");
    }

    @Test
    @DisplayName("운전실력이 기준 미만이면 이동하지 않는지 테스트")
    void testCarDontMoveParameterIsLessThanCriteria() {
        car.move(DomainConstant.SUFFICIENT_DRIVING_SKILL_CRITERIA_VALUE - 1);

        assertThat(car.getPosition()).isEqualTo(
                DomainConstant.INITIAL_POSITION + DomainConstant.WHEN_FAIL_MOVE_DISTANCE);
    }

    @Test
    @DisplayName("운전실력이 기준 이상이면 한칸 이동 테스트")
    void testCarMoveOneDistanceParameterIsGREATERThanOrEqualCriteria() {
        car.move(DomainConstant.SUFFICIENT_DRIVING_SKILL_CRITERIA_VALUE + 1);

        assertThat(car.getPosition()).isEqualTo(
                DomainConstant.INITIAL_POSITION + DomainConstant.WHEN_SUCCESS_MOVE_DISTANCE);
    }
}
