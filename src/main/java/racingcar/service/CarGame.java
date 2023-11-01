package racingcar.service;

import java.util.List;
import racingcar.domain.TotalCar;
import racingcar.view.OutputView;

public class CarGame {
    private final OutputView output;

    public CarGame(OutputView output) {
        this.output = output;
    }

    public void run(int attempt, TotalCar totalCar) {
        output.showResultNotice();
        for (int move = 0; move < attempt; move++) {
            saveResult(totalCar);
            showResult(totalCar);
            output.showLine();
        }
    }

    public void saveResult(TotalCar totalCar) {
        totalCar.moveDistance();
    }

    public void showResult(TotalCar totalCar) {
        List<String> names = totalCar.nameList();
        List<Integer> distances = totalCar.distanceList();
        for (int result = 0; result < names.size(); result++) {
            output.showName(names.get(result));
            output.showColon();
            output.showMove(distances.get(result));
            output.showLine();
        }
    }
}