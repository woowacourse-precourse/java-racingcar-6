package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("생성한 Car와 이름이 같으면 성공한다.")
    void 이름_성공_테스트() {
        //given
        Car car = new Car("test");
        //when, then
        assertThat(car.getName()).isEqualTo("test");
    }

    @Test
    @DisplayName("생성한 Car와 이름이 같으면 성공한다.")
    void 거리_초기화_테스트() {
        //given
        Car car = new Car("test");
        //when, then
        assertThat(car.getDistance()).isZero();
    }

    @Test
    @DisplayName("이동한 거리가 3과 같으면 성공")
    void 거리_3_성공_테스트() {
        MoveRule moveRule = createMoveRule(3);
        //given
        Car car = new Car("test");
        //when
        car.move(moveRule);
        //then
        assertThat(car.getDistance()).isEqualTo(3);
    }

    private MoveRule createMoveRule(int generateNumber) {
        return new MoveRule() {
            @Override
            public int tryMove() {
                return generateNumber;
            }
        };
    }
}