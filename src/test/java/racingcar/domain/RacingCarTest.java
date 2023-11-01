package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    private RacingCar car;

    @BeforeEach
    void beforeEach() {
        car = new RacingCar("test_car");
    }

    @Test
    @DisplayName("초기 위치 테스트")
    void initialPosition() {
        int position = car.getPosition();
        assertThat(position).isEqualTo(0);
    }

    @Test
    @DisplayName("이름 테스트")
    void getName() {
        String name = car.getName();
        assertThat(name).isEqualTo("test_car");
    }

    @Test
    @DisplayName("정상적으로 이동하는 경우")
    void move() {
        int initialPosition = car.getPosition();
        boolean moved = car.move();
        int finalPosition = car.getPosition();

        if (moved) {
            assertThat(finalPosition).isEqualTo(initialPosition + 1);
        } else {
            assertThat(finalPosition).isEqualTo(initialPosition);
        }
    }

    @Test
    @DisplayName("이동 횟수와 '-' 개수가 같은지 확인")
    void toStringWithDashes() {
        int count = 0;
        for (int i = 0; i < Randoms.pickNumberInRange(0, 100); i++) {
            boolean moved = car.move();
            if (moved) {
                count++;
            }
        }

        int length = car.toString().length() - car.getName().length() - " : ".length();

        assertThat(length).isEqualTo(count);
    }
}