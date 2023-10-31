package car;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;
    @BeforeEach // BeforeEach 에서 검증(assert) 를 해도 될까?
    void init() {
        String name = "testCar";
        car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("익명 클래스를 활용한 오버라이드로 움직일지를 더 유연하게 판별하기")
    void move_by_strategy() {
        car.moveByStrategy(() -> false);
        assertThat(car.getLocation()).isZero();
        car.moveByStrategy(() -> true);
        assertThat(car.getLocation()).isOne();
    }

    @Test
    @DisplayName("랜덤 값은 외부에서 주입하고, move 매소드 내부에서는 값을 판별해서 리턴")
    void move_by_given_condition() {
        car.moveByGivenCondition(3);
        assertThat(car.getLocation()).isZero();
        car.moveByGivenCondition(4);
        assertThat(car.getLocation()).isOne();
    }

    @Test
    @DisplayName("4 이상의 수가 나오면 successCount를 올리고, 차의 위치가 해당 카운트와 같은지 판별한다.")
    void move_with_random_value_test() {
        int testTrial = 1000;
        int successCount = 0;
        for (int i = 0; i < testTrial; i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) successCount++;
            car.moveByGivenCondition(randomNumber);
        }
        assertThat(car.getLocation()).isEqualTo(successCount);
    }
}