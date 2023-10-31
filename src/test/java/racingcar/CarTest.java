package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

public class CarTest {
    Car car = new Car("name");

    @RepeatedTest(10)
    void 자동차_주행_테스트() {
        for (int i = 0; i < 5; i++) {
            car.driving();
        }
        // 주행을 5번 시도했을 때 "-"를 포함하는지 확인 -> 약 1프로의 확률로 포함되지 않을 수 있음
        assertThat(car.getDistanceDriven()).as("운이 나빠서 '-'가 포함되지 않았어요!").contains("-");
        // 주행거리 문자열의 길이가 5보다 작은지 확인
        assertThat(car.getDistanceDriven()).hasSizeLessThanOrEqualTo(5);
    }
}
