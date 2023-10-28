package racingcar;

import racingcar.entity.Cars;
import racingcar.entity.MovePolicy;
import racingcar.mapper.Delimiter;
import racingcar.mapper.InputMapper;

import java.util.List;

import static racingcar.view.InputView.readNames;
import static racingcar.view.InputView.readTimes;
import static racingcar.view.OutputView.*;

class Controller {

    private final MovePolicy policy;

    public Controller(MovePolicy policy) {
        this.policy = policy;
    }

    public void run() {
        Cars cars = createCars();

        race(getRaceTimes(), cars);

        showRaceResult(cars);
    }

    private Cars createCars() {
        return Cars.from(getCarNames());
    }

    private List<String> getCarNames() {
        Delimiter delimiter = InputMapper.getNameListDelimiter();

        return InputMapper.mapToNameList(readNames(delimiter.getName(), delimiter.getShape()));
    }

    private int getRaceTimes() {
        return InputMapper.mapToPositiveNumber(readTimes());
    }

    private void race(int maxTimes, Cars cars) {
        printResultHeader();

        for (int times = 0; times < maxTimes; times++) {
            cars.moveAll(policy);

            printResult(cars.describeAll());
        }
    }

    private void showRaceResult(Cars cars) {
        printWinner(cars.findFrontCarsName());
    }
}
