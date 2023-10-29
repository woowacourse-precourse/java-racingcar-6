package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;
import racingcar.Application;
import racingcar.model.Car;

public class OutputViewTest extends NsTest {
    private OutputView outputView = new OutputView();
    private static final int MOVING_FORWARD = 4;

    @Test
    void 우승결과_출력_두명() {
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"));
        for(Car car : cars) {
            car.goOrStop(MOVING_FORWARD);
            car.goOrStop(MOVING_FORWARD);
        }

        outputView.displayResults(cars);
        assertThat(output()).contains("최종 우승자 : pobi, woni");
    }

    @Test
    void 우승결과_출력_한명() {
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"));
        Car pobi = cars.get(0);
        pobi.goOrStop(MOVING_FORWARD);
        pobi.goOrStop(MOVING_FORWARD);

        outputView.displayResults(cars);
        assertThat(output()).contains("최종 우승자 : pobi");
    }


    @Test
    void 주행결과_출력_테스트() {
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"));
        for(Car car : cars) {
            car.goOrStop(MOVING_FORWARD);
            car.goOrStop(MOVING_FORWARD);
        }

        outputView.displayPerResults(cars);
        assertThat(output()).contains("pobi : --", "woni : --");
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
