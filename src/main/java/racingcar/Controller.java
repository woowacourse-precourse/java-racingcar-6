package racingcar;

import racingcar.entity.Cars;
import racingcar.entity.MovePolicy;
import racingcar.mapper.Delimiter;
import racingcar.mapper.InputMapper;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

class Controller {

    private final MovePolicy policy;

    public Controller(MovePolicy policy) {
        this.policy = policy;
    }

    public void run() {
        Cars cars = Cars.from(readNames());
        int tryCount = readTryCount();
        race(tryCount, cars);
        showWinner(cars);
    }

    private List<String> readNames() {
        Delimiter delimiter = InputMapper.getNameListDelimiter();

        return InputMapper.mapToNameList(InputView.readNames(delimiter.getName(), delimiter.getShape()));
    }

    private int readTryCount() {
        return InputMapper.mapToPositiveNumber(InputView.readTryCount());
    }

    private void race(int tryCount, Cars cars) {
        OutputView.printResultHeader();

        for (int i = 0; i < tryCount; i++) {
            cars.moveAll(policy);

            OutputView.printResult(cars.describeAll());
        }
    }

    private void showWinner(Cars cars) {
        OutputView.printWinner(cars.findFrontCarsName());
    }
}
