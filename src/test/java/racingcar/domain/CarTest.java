package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final String CAR_NAME = "car";
    private static final String CAR1_NAME = "car1";
    private static final String CAR2_NAME = "car2";

    @Test
    @DisplayName("compareTo 함수 기능 테스트")
    void 두_개의_값을_비교하는_기능_테스트() {
        //given
        Car car1 = new Car(CAR1_NAME);
        Car car2 = new Car(CAR2_NAME);
        //when
        assertEquals(car1.compareTo(car2), 0);
        car1.moveForward(MOVING_FORWARD);
        //then
        assertEquals(car1.compareTo(car2), 1);
    }

    @Test
    @DisplayName("getName 함수 기능 테스트")
    void 자동차_이름_반환_기능_테스트() {
        //given
        Car car = new Car(CAR_NAME);
        //then
        assertEquals(car.getName(), CAR_NAME);
    }

    @Test
    @DisplayName("getPosition 함수 기능 테스트")
    void 자동차_이동거리_반환_기능_테스트() {
        //given
        Car car = new Car(CAR_NAME);
        //then
        assertEquals(car.getPosition(), 0);
    }

    @Test
    @DisplayName("isSamePosition 함수 기능 테스트")
    void 이동거리가_같은_자동차_확인_기능_테스트() {
        //given
        Car car1 = new Car(CAR1_NAME);
        Car car2 = new Car(CAR2_NAME);
        assertTrue(car1.isSamePosition(car2));
        //when
        car1.moveForward(MOVING_FORWARD);
        //then
        assertFalse(car1.isSamePosition(car2));
    }

    @Test
    @DisplayName("moveForward 함수 기능 테스트")
    void 자동차_전진_기능_테스트() {
        //given
        Car car1 = new Car(CAR1_NAME);
        Car car2 = new Car(CAR2_NAME);
        //when
        car1.moveForward(MOVING_FORWARD);
        car2.moveForward(STOP);
        //then
        assertEquals(car1.getPosition(), 1);
        assertEquals(car2.getPosition(), 0);
    }

    @Override
    protected void runMain() {
        Car car = new Car(CAR_NAME);
        car.moveForward(MOVING_FORWARD);
    }
}
