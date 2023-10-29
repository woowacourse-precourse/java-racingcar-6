package racingcar.service.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    final static int CAN_MOVE_EDGE_CONDITION = 4;
    final static int CANT_MOVE_EDGE_CONDITION = 3;

    @Test
    @DisplayName("[성공 테스트] 8번의 움직임 중 4번만 4이상의 수를 생성하여 자동차 4번 움직임")
    void moveTest() {
        // given
        Car car = new Car("junGi", new CustomEngine());
        int totalMoveOrder = 8;
        long expectedMoveCount = 4;
        // when
        for (int move = 0; move < totalMoveOrder; move++) {
            car.moveCar();
        }
        // then
        Assertions.assertThat(car.getTotalMoveCount()).isEqualTo(expectedMoveCount);
    }

    @Test
    @DisplayName("[엣지 테스트] 움직임 가능한 최소값 4일 때 자동차 움직임")
    void moveSuccessEdgeTest() {
        // given
        Car car = new Car("junGi", () -> CAN_MOVE_EDGE_CONDITION);
        long expectedMoveCount = 1;
        // when
        car.moveCar();
        // then
        Assertions.assertThat(car.getTotalMoveCount()).isEqualTo(expectedMoveCount);
    }

    @Test
    @DisplayName("[엣지 테스트] 움직임 불가한 최댓값 3일 때 자동차 움직임 불가")
    void moveFailEdgeTest() {
        // given
        Car car = new Car("p", () -> CANT_MOVE_EDGE_CONDITION);
        long expectedMoveCount = 0;
        // when
        car.moveCar();
        // then
        Assertions.assertThat(car.getTotalMoveCount()).isEqualTo(expectedMoveCount);
    }

    static class CustomEngine implements Engine {

        List<Integer> enginePowers = Lists.newArrayList(1, 4, 0, 9, 2, 3, 4, 8);

        @Override
        public int generateNumber() {
            return enginePowers.remove(0);
        }
    }
}