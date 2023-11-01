package racingcar.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Domain.Car;
import racingcar.Domain.Cars;
import racingcar.View.OutputView;

public class RaceController {

    private static final String SEPARATOR = ",";
    private static final int MINIMUM_TRY_COUNT = 1;
    private static final int MINIMUM_ENTRY_COUNT = 2;

    private final String carNames;
    private final int tryCount;

    public RaceController(String carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    private Cars makeCars(String carNames) {
        String[] entries = carNames.split(SEPARATOR);

        return new Cars(Arrays.stream(entries)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public void run() {
        Cars cars = makeCars(carNames);

        OutputView.printRaceProgressMsg();
        for (int i = 0; i < tryCount; i++) {
            cars.moveAll();
            OutputView.printRaceProgress(cars);
        }

        List<Car> winners = cars.findWinners();
        OutputView.printFinalWinnerMsg();
        OutputView.printFinalWinner(winners);
    }
}
