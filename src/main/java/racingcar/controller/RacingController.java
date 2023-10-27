package racingcar.controller;

import racingcar.domain.CarGenerator;
import racingcar.domain.RacingCars;
import racingcar.util.Convertor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public void startGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = InputView.inputCarNames();
        System.out.println("시도할 회수는 몇회인가요?");
        RacingCars racingCars = new RacingCars(CarGenerator.generateParticipationCarList(carNames));
        racing(racingCars);
        OutputView.printWinner(racingCars.getWinner());
    }

    private void racing(RacingCars racingCars) {
        int tryCount = Convertor.convertStringToInt(InputView.inputTryCount());
        System.out.println("\n실행 결과");
        while (tryCount > 0) {
            racingCars.move();
            OutputView.printResult(racingCars.getCarStatuses());
            tryCount--;
        }
    }
}
