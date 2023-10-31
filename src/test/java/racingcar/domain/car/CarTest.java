package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.config.GameConfig.*;

@DisplayName("CarTest")
class CarTest {

    private Car car1;
    private Car car2;

    @BeforeEach
    void init() {
        // given
        car1 = new Car("name1");
        car2 = new Car("name2");
    }

    @Test
    @DisplayName("기준값보다 높은 값을 넣었을 때, 자동차가 이동한다.")
    void car_move() { /// 랜덤
        // given
        int randomNumber = MOVEMENT_CONDITION_NUMBER.getNumber() + 1;

        // when
        car1.move(randomNumber);

        // then
        assertThat(car1.getDistance()).isEqualTo(1);

    }

    @Test
    @DisplayName("기준값보다 낮은 값을 넣었을 때, 자동차가 이동하지 않는다.")
    void move_() { /// 랜덤
        // given
        int randomNumber = MOVEMENT_CONDITION_NUMBER.getNumber() - 1;

        // when
        car1.move(randomNumber);

        // then
        assertThat(car1.getDistance()).isEqualTo(0);

    }

    @Test
    @DisplayName("범위 안의 랜덤한 숫자를 뽑는다.")
    void getRandomNumber() {
        // given, when
        int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_START.getNumber(), RANDOM_NUMBER_RANGE_END.getNumber());

        // then
        assertThat(randomNumber).isGreaterThanOrEqualTo(RANDOM_NUMBER_RANGE_START.getNumber()).isLessThanOrEqualTo(RANDOM_NUMBER_RANGE_END.getNumber());
    }

    @Test
    @DisplayName("자동차1이 2번 이동하고 자동차2가 1번 이동하면 자동차1이 자동차2보다 더 멀리 있다.")
    void isSameDistanceOrFurtherThan() { // 랜덤
        // given
        int randomNumber = MOVEMENT_CONDITION_NUMBER.getNumber();

        // when
        car1.move(randomNumber);
        car1.move(randomNumber);
        car2.move(randomNumber);

        // then
        assertThat(car1.isSameDistanceOrFurtherThan(car2)).isEqualTo(true);
    }

    @Test
    @DisplayName("자동차의 이름을 반환한다.")
    void getName() {
        // when
        String name = car1.getName();

        // then
        assertThat(name).isEqualTo("name1");
    }

    @Test
    @DisplayName("자동차의 이동 거리를 반환한다.")
    void getDistance() {
        // when
        int distance = car1.getDistance();

        // then
        assertThat(distance).isEqualTo(0);
    }
}