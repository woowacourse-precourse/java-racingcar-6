package racingcar.service.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    final static int CAN_MOVE_EDGE_CONDITION = 4;
    final static int CANT_MOVE_EDGE_CONDITION = 3;

    @Nested
    @DisplayName("자동차 움직임 테스트")
    class MoveCarTest {
        @CsvSource(value = "8,4")
        @DisplayName("[성공 테스트] 8번의 움직임 중 4번만 4이상의 수를 생성하여 자동차 4번 움직임")
        void moveTest(int totalMoveOrder, int expectedMoveCount) {
            // given
            Car car = new Car("junGi", new CustomCarEngine());
            // when
            for (int move = 0; move < totalMoveOrder; move++) {
                car.moveCar();
            }
            // then
            Assertions.assertThat(car.getPosition()).isEqualTo(expectedMoveCount);
        }

        @Test
        @DisplayName("[엣지 테스트] 움직임 가능한 최소값 4일 때 자동차 움직임")
        void moveSuccessEdgeTest() {
            // given
            Car car = new Car("junGi", () -> CAN_MOVE_EDGE_CONDITION);
            int expectedMoveCount = 1;
            // when
            car.moveCar();
            // then
            Assertions.assertThat(car.getPosition()).isEqualTo(expectedMoveCount);
        }

        @Test
        @DisplayName("[엣지 테스트] 움직임 불가한 최댓값 3일 때 자동차 움직임 불가")
        void moveFailEdgeTest() {
            // given
            Car car = new Car("p", () -> CANT_MOVE_EDGE_CONDITION);
            int expectedMoveCount = 0;
            // when
            car.moveCar();
            // then
            Assertions.assertThat(car.getPosition()).isEqualTo(expectedMoveCount);
        }

        static class CustomCarEngine implements CarEngine {

            List<Integer> enginePowers = Lists.newArrayList(1, 4, 0, 9, 2, 3, 4, 8);

            @Override
            public int generateNumber() {
                return enginePowers.remove(0);
            }
        }
    }

    @Nested
    @DisplayName("자동차 생성 테스트")
    class CreateCarTest {
        @ParameterizedTest
        @ValueSource(strings = {"1,", "j,ung", "JA,Z", "JQA,!", "K,IG!"})
        @DisplayName("[실패 테스트] 자동차 이름에 콤마가 존재")
        void commaExistsTest(String name) {
            Assertions.assertThatThrownBy(() -> new Car(name, new WootecoCarEngine()))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"", " ", "  ", "   ", "    ", "     "})
        @DisplayName("[실패 테스트] 자동차 이름에 공백만 존재")
        void blankTest(String name) {
            Assertions.assertThatThrownBy(() -> new Car(name, new WootecoCarEngine()))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"jungiK", "     !", "K     ", "       Kim", "myNameIsJAZ"})
        @DisplayName("[실패 테스트] 유효하지 않은 자동차 길이")
        void outOfLengthTest(String name) {
            Assertions.assertThatThrownBy(() -> new Car(name, new WootecoCarEngine()))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}