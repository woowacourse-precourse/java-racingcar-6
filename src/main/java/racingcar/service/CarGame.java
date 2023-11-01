package racingcar.service;

import java.util.List;
import racingcar.domain.TotalCar;
import racingcar.util.Message;
import racingcar.view.OutputView;

public class CarGame {
    private final OutputView output;

    public CarGame(OutputView output) {
        this.output = output;
    }

    public void run(int attempt, TotalCar totalCar) {
        output.write(Message.RESULT_MESSAGE);
        for (int move = 0; move < attempt; move++) {
            saveResult(totalCar);
            showResult(totalCar);
            output.write(Message.LINE);
        }
    }

    public void saveResult(TotalCar totalCar) {
        totalCar.moveDistance();
    }

    public void showResult(TotalCar totalCar) {
        List<String> names = totalCar.nameList();
        List<Integer> distances = totalCar.distanceList();
        for (int result = 0; result < names.size(); result++) {
            output.write(names.get(result));
            output.write(Message.COLON);
            output.showMove(distances.get(result));
            output.write(Message.LINE);
        }
    }
}