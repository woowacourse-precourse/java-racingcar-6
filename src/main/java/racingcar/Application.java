package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.views.InputView;
import racingcar.views.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.racingCarOpeningComment();
        List<Car> carNames = InputView.getCarNames();
        for (Car car : carNames) {
            System.out.println("car.getName() = " + car.getName());
        }
    }
}
