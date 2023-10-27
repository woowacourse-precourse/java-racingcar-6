package racingcar;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

public class CarTest {
    Car car = new Car("name");

    @Test
    void 랜덤숫자_생성기_테스트() {
        int randomNumber = car.createRandomNumber();
        // 랜덤 숫자가 0에서 9 사이에 있는 숫자인지 확인
        assertThat(randomNumber).isLessThan(10);
        assertThat(randomNumber).isGreaterThan(-1);
    }

    @Test
    void 자동차_주행_테스트() {
        for (int i = 0; i < 5; i++) {
            car.driving();
        }
        // 주행을 5번 시도했을 때 "-"를 포함하는지 확인
        // 주행거리 문자열의 길이가 5보다 작은지 확인
        assertThat(car.distanceDriven).as("운이 나빠서 '-'가 포함되지 않았어요!").contains("-");
        assertThat(car.distanceDriven).hasSizeLessThanOrEqualTo(5);
    }

    public class Car {
        private String carName;
        private String distanceDriven = "";

        public Car(String carName) {
            this.carName = carName;
        }

        public int createRandomNumber() {
            return Randoms.pickNumberInRange(0, 9);
        }

        public void moveForward(int randomNum) {
            if (randomNum >= 4) {
                this.distanceDriven += "-";
            }
        }

        public void driving() {
            int randomNum = createRandomNumber();
            moveForward(randomNum);
        }
    }
}
