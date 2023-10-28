package racingcar.View;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private OutputView outputView;
    private Car car;

    @BeforeEach
    void setOutputView() {
        outputView = new OutputView();
        car = new Car("정연", 4);
    }

    @Test
    void 일회_사이클_출력화면() {
        String result = outputView.carResult(car);
        assertThat(result).isEqualTo("정연 : ----");
    }

}