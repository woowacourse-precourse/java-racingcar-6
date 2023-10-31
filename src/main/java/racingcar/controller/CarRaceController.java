package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.CarRaceModel;
import racingcar.view.CarRaceView;

import java.util.List;

public class CarRaceController {
    private CarRaceModel model;
    private CarRaceView view;

    public CarRaceController(CarRaceModel model, CarRaceView view) {
        this.model = model;
        this.view = view;
    }

    public void runGame() {
        view.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = view.splitCarNames(Console.readLine());
        view.print("시도할 회수는 몇회인가요?");
        int numAttempts = Integer.parseInt(Console.readLine());

        model.initialize(carNames);

        view.print("\n실행결과");
        moveCars(model.getResults(), numAttempts);

        List<String> winners = model.calculateWinners();

        view.printWinners(winners);
    }

    private void moveCars(List<String> results, int numAttempts) {
        for (int attempt =0; attempt < numAttempts; attempt++){
            for (int i = 0; i < results.size(); i++) {
                if (shouldCarMove()) {
                    String currentResult = results.get(i);
                    results.set(i, currentResult + "-");
                }
            }
            view.printResults(results);
        }
    }

    private boolean shouldCarMove() {
        int move = Randoms.pickNumberInRange(0, 9);
        return move >= 4;
    }
}
