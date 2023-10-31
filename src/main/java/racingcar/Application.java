package racingcar;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        /* 자동차 이름을 입력받고, 자동차 객체 생성(자동차 컨트롤러에서 관리) */
        System.out.println(OutputView.pleaseInputCarsName());
        String[] carNames = InputView.inputCarNames();
        CarController carController = new CarController(carNames);

        /* 반복 회수 입력받기 */
        System.out.println(OutputView.pleaseInputTriesCount());
        final int numberOfTries = InputView.inputNumberOfTries();

        /* 반복 실행 시작 */
        System.out.println(OutputView.triesStartMessage());
        for (int i = 0; i < numberOfTries; i++) {
            carController.tryToMoveForward();
            carController.printCarsMovePoint();
        }

        /* 우승한 자동차를 찾아서 결과 출력 */
        final Car maxMovePoint = carController.getMaxMovePointCar();
        List<String> winners = carController.findHaveSamePointCars(maxMovePoint);
        System.out.print(OutputView.finalWinnerMessage());
        winners.stream()
                .map(o -> o + ", ")
                .forEach(System.out::print);
    }
}
