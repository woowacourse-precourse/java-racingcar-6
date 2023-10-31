package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import camp.nextstep.edu.missionutils.test.NsTest;

class CarTest extends NsTest {
    @CsvSource({
            "pobi",
            "woni",
            "jun",
            "mooso",
            "''",
    })
    @ParameterizedTest
    void 자동차_생성_성공(String carName) {
        assertThatCode(() -> Car.fromString(carName)).doesNotThrowAnyException();
    }

    @CsvSource({
            "pobioo",
            "wonioo",
            "junooo",
            "moosoo"
    })
    @ParameterizedTest
    void 자동차_생성_실패(String carName) {
        assertThatThrownBy(() -> Car.fromString(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 자동차_생성_시_상태는_멈춤으로_설정() {
        Car givenCar = Car.fromString("mooso");
        Status givenCarStatus = givenCar.getCarStatus();
        Status expectedStatus = Status.STOP;
        assertThat(givenCarStatus).isEqualTo(expectedStatus);

    }

    @Test
    void 자동차_생성_시_위치는_0으로_설정() {
        Car givenCar = Car.fromString("mooso");
        Location givenCarLocation = givenCar.getCarLocation();
        Location expectedLocation = Location.fromInteger(0);
        assertThat(givenCarLocation).isEqualTo(expectedLocation);

    }

    @Test
    void 자동차_상태_값_변경() {
        Car givenCar = Car.fromString("mooso");
        givenCar.setCarStatus(Status.MOVING_FORWARD);

        Status givenCarStatus = givenCar.getCarStatus();
        Status expectedStatus = Status.MOVING_FORWARD;
        assertThat(givenCarStatus).isEqualTo(expectedStatus);

    }

    @Test
    void 자동차_상태가_이동일때_이동하면_위치값_1단계_증가() {
        Car givenCar = Car.fromString("mooso");
        givenCar.setCarStatus(Status.MOVING_FORWARD);
        givenCar.move();
        Location givenCarLocation = givenCar.getCarLocation();
        Location expectedLocation = Location.fromInteger(1);
        assertThat(givenCarLocation).isEqualTo(expectedLocation);
    }

    @Test
    void 자동차_상태가_이동일때_이동하면_상태가_멈춤으로_변경() {
        Car givenCar = Car.fromString("mooso");
        givenCar.setCarStatus(Status.MOVING_FORWARD);
        givenCar.move();
        Status givenCarStatus = givenCar.getCarStatus();
        Status expectedStatus = Status.STOP;
        assertThat(givenCarStatus).isEqualTo(expectedStatus);
    }

    @CsvSource({
            "mooso,4,'mooso : ----'",
            "pobi,7,'pobi : -------'",
            "woni,0,'woni : '",
            "jun,5, 'jun : -----'"
    })
    @ParameterizedTest
    void 자동차_현재_위치_값_반환(String givenCarName, int moveCount, String expected) {
        Car givenCar = Car.fromString(givenCarName);
        int initCount = 0;

        while (initCount < moveCount) {
            givenCar.setCarStatus(Status.MOVING_FORWARD);
            givenCar.move();
            initCount++;
        }
        givenCar.displayCarLocation();
        assertThat(output()).contains(expected);
    }

    @Test
    void 자동차_랜덤_값이_4이상이면_이동하기() {
        assertRandomNumberInRangeTest(() -> {
            Car givenCar = Car.fromString("mooso");
            givenCar.moveCarOnRandomCondition();
            givenCar.moveCarOnRandomCondition();
            givenCar.moveCarOnRandomCondition();
            givenCar.moveCarOnRandomCondition();
            givenCar.moveCarOnRandomCondition();
            Location givenCarLocation = givenCar.getCarLocation();
            Location expectedLocation = Location.fromInteger(4);
            assertThat(givenCarLocation).isEqualTo(expectedLocation);
        }, 3, 4, 5, 6, 7);
    }

    @Override
    protected void runMain() {
        // TODO Auto-generated method stub

    }
}
