package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberGenerator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("입력된 이름이 5글자보다 많은 경우")
    void 예외_처리_테스트_1() {
        MovingStrategy movingStrategy = new MovingStrategy(new RandomNumberGenerator());
        assertThrows(IllegalArgumentException.class,
                () -> {
            new Car(movingStrategy, "yeonuel", 0);
        });
    }

    @Test
    @DisplayName("공백이 입력된 경우")
    void 예외_처리_테스트_2() {
        MovingStrategy movingStrategy = new MovingStrategy(new RandomNumberGenerator());
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new Car(movingStrategy, "", 0);
                });
    }

    @Test
    @DisplayName("자동차 시작 위치가 0이 아닌 경우")
    void 예외_처리_테스트_3() {
        MovingStrategy movingStrategy = new MovingStrategy(new RandomNumberGenerator());
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new Car(movingStrategy, "pobi", 1);
                });
    }

    @Test
    @DisplayName("MovingStrategy.isCarMove()가 false인 경우 goForward() 호출하면 위치 정보 업데이트 안됨")
    void goForward_멈춤_테스트() {
        // given
        MovingStrategy stopStrategy = new MovingStrategy(() -> 3); // isCarMove() 항상 false 반환
        Car car = new Car(stopStrategy, "pobi", 0);
        // when
        Boolean result = car.goForward();
        // then
        assertEquals(false, result);
        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("MovingStrategy.isCarMove()가 true인 경우 goForward() 호출하면 위치 정보 업데이트됨")
    void goForward_전진_테스트() {
        // given
        MovingStrategy stopStrategy = new MovingStrategy(() -> 4); // isCarMove() 항상 true 반환
        Car car = new Car(stopStrategy, "pobi", 0);
        // when
        Boolean result = car.goForward();
        // then
        assertEquals(true, result);
        assertEquals(1, car.getPosition());
    }


}