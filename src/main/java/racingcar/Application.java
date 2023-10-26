package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.views.InputView;
import racingcar.views.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 오프닝 멘트
        OutputView.racingCarOpeningComment();
        // 자동차 이름 입력 받기
        List<Car> carNames = InputView.getCarNames();
        for (Car car : carNames) {
            System.out.println("car.getName() = " + car.getName());
        }
        // 도전 횟수 받기
        OutputView.tryCountInputComment();
    }
}
