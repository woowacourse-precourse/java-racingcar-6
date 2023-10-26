package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.OutputTestSupport;
import racingcar.constants.MessageConstants;
import racingcar.entity.car.Car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.constants.MessageConstants.*;

class ExecutionViewTest extends OutputTestSupport {

    @Test
    @DisplayName("실행 시작 메시지를 출력할 수 있다.")
    public void printExecutionStartMessage() {
        // given // when
        ExecutionView.printExecutionStartMessage();
        // then
        assertThat(output()).isEqualTo(EXECUTION_START_MESSAGE);
    }

    @Test
    @DisplayName("자동차의 이름과 움직인 거리를 포멧에 맞게 출력할 수 있다.")
    public void printExecutionMessage() {
        // given
        Car car = new Car("myCar");
        car.controlMovement(4); // 전진 1회
        // when
        ExecutionView.printExecutionMessage(car);
        // then
        assertThat(output()).isEqualTo("myCar : -");
    }

}