package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.OutputTestSupport;
import racingcar.domain.car.Car;
import racingcar.dto.PrintCarDetailsDto;

import static org.assertj.core.api.Assertions.*;
import static racingcar.constants.GameMessage.EXECUTION_START_MESSAGE;

class ExecutionViewTest extends OutputTestSupport {

    private ExecutionView executionView = new ExecutionView();

    @Test
    @DisplayName("실행 시작 메시지를 출력할 수 있다.")
    public void printExecutionStartMessage() {
        // given // when
        executionView.printExecutionStartMessage();
        // then
        assertThat(outputWithoutTrim()).isEqualTo(EXECUTION_START_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("자동차의 이름과 움직인 거리를 포멧에 맞게 출력할 수 있다.")
    public void printExecutionMessage() {
        // given
        Car car = new Car("myCar");
        car.controlMovement(4); // 전진 1회
        // when
        executionView.printExecutionMessage(new PrintCarDetailsDto(car));
        // then
        assertThat(outputWithoutTrim()).isEqualTo("myCar : -");
    }

    @Test
    @DisplayName("개행문자 newLine을 출력할 수 있다.")
    public void newLine() {
        // given // when
        executionView.newLine();
        // then
        assertThat(getOutput()).isEqualTo("\n");
    }

}