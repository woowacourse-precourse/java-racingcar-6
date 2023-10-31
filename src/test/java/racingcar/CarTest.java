package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 생성자_확인_테스트() {
        String carName = "TestCar";

        Car car = new Car(carName);

        assertThat(car.getName()).isEqualTo(carName); // 생성자가 이름을 올바르게 설정했는지 확인
        assertThat(car.getPosition()).isEqualTo(0);     // 생성자가 위치를 0으로 설정했는지 확인
    }

    @Test
    void 랜덤값을_비교해서_포지션_추가_테스트() {
        // Given
        Car car = new Car("TestCar");
        int initialPosition = car.getPosition();

        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            car.move(randomNumber);
        }

        if (randomNumber >= 4) {
            assertThat(car.getPosition()).isEqualTo(initialPosition + 1);
        } else {
            assertThat(car.getPosition()).isEqualTo(initialPosition);
        }
    }

    @Test
    void getName_테스트() {
        String carName = "TestCar";
        Car car = new Car(carName);

        String retrievedName = car.getName();

        assertThat(retrievedName).isEqualTo(carName);
    }
}