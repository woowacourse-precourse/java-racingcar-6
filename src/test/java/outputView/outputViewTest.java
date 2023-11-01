package outputView;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.view.OutputView;

public class outputViewTest {
    private final OutputView outputView = new OutputView();
    @Test
    void 리스트를_콤파_기준으로_분리된_문자열로_변환시킨다() {
        List<Car> cars = List.of(new Car("abc"), new Car("def"));

        String output = outputView.joinBy(cars, ", ");

        Assertions.assertThat(output).isEqualTo("abc, def");
    }
}
