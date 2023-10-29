package racingcar;

import racingcar.entity.Cars;
import racingcar.entity.MovePolicy;
import racingcar.mapper.Delimiter;
import racingcar.mapper.InputMapper;

import java.util.List;
import java.util.stream.IntStream;

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
        race(cars);
        showWinner(cars);
    }

    private Cars createCars() {
        return Cars.from(getCarNames());
    }

    private List<String> getCarNames() {
        Delimiter delimiter = InputMapper.getNameListDelimiter();

        return InputMapper.mapToNameList(readNames(delimiter.getName(), delimiter.getShape()));
    }

    private void race(Cars cars) {
        int raceTimes = getRaceTimes();

        printResultHeader();
        IntStream.range(0, raceTimes)
                .forEach(times -> raceOneTimes(cars));
    }

    private int getRaceTimes() {
        return InputMapper.mapToPositiveNumber(readTimes());
    }

    private void raceOneTimes(Cars cars) {
        cars.moveAll(policy);
        printResult(cars.describeAll());
    }

    private void showWinner(Cars cars) {
        printWinner(cars.findFrontCarsName());
    }
}
