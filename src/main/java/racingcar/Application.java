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
        // 도전 횟수 멘트
        OutputView.tryCountInputComment();
        // 도전 횟수 입력 받기
        Integer tryCount = InputView.getTryCount();
        System.out.println("tryCount = " + tryCount);

        // 레이싱 게임 결과 멘트
        OutputView.racingCarResultComment();

        
    }
}
