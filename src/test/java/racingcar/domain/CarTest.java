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

}