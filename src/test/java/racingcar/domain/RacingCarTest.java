package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RacingCarTest {

    private static final String TEST_CAR_NAME = "testCar";
    private static final int TEST_TRY = 1000;   //테스트 시도 횟수
    private static final int MOVE_TRY = 100000; //전진 시도 횟수
    private static final int EXPECTED_DISTANCE = 60000; //예상값
    private static final int ERROR_MARGIN = 5000;   //허용 오차 5%

    @Test
    void moveForward_전진_반복_테스트() {
        for (int i = 0; i < TEST_TRY; i++) {
            moveForward_10만번_반복();
        }
    }

    private void moveForward_10만번_반복() {
        RacingCar car = new RacingCar(TEST_CAR_NAME);
        for (int i = 0; i < MOVE_TRY; i++) {
            car.moveForward();
        }
        assertEquals(car.getDistance(), EXPECTED_DISTANCE, ERROR_MARGIN);
    }

    @Test
    void convertDistanceToString_현재이동거리_문자열_변환_테스트() {
        RacingCar car = new RacingCar(TEST_CAR_NAME);
        for (int i = 0; i < MOVE_TRY; i++) {
            car.moveForward();
        }

        int distance = car.getDistance();
        String result = car.convertDistanceToString();

        assertThat(result.length()).isEqualTo(distance);
    }

}