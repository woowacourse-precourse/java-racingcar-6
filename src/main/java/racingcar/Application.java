package racingcar;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/**
 * [자동차 경주 미션 구현 프로그램]
 * Application클래스는 자동차 경주 프로그램의 main클래스로 전체적인 흐름을 구현하였다.
 */
public class Application {
    public static void main(String[] args) {
        /* 자동차 이름을 입력받고, 자동차 객체 생성(자동차 컨트롤러에서 관리) */
        System.out.println(OutputView.pleaseInputCarsName());
        String[] carNames = InputView.inputCarNames();
        CarController carController = new CarController(carNames);

        /* 시도 회차 반복 회수 입력받기 */
        System.out.println(OutputView.pleaseInputTriesCount());
        final int numberOfTries = InputView.inputNumberOfTries();

        /* n회차 반복 실행 시작 */
        System.out.println(OutputView.triesStartMessage());
        for (int i = 0; i < numberOfTries; i++) {
            carController.tryToMoveForward();
            carController.printCarsMovePoint();
        }

        /* 우승한 자동차를 찾아서 결과 출력 */
        System.out.print(OutputView.finalWinnerMessage());
        final Car maxMovePointCar = carController.getMaxMovePointCar();
        List<String> winners = carController.findHaveSamePointCars(maxMovePointCar);
        if (winners.size() > 1) { // 우승자가 2명 이상일 경우
            System.out.println(String.join(", ", winners));
        } else if (winners.size() == 1) { // 우승자가 1명일 경우
            System.out.println(winners.get(0));
        }
    }
}
