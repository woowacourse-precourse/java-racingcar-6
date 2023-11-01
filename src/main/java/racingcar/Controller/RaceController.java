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
    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String carNames;
    private final int tryCount;

    public RaceController(String carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
    }

    private void isValidName(String name) {
        if(name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    "이름은 최소 "
                            + MINIMUM_NAME_LENGTH + "자에서 최대 "
                            + MAXIMUM_NAME_LENGTH + "자 사이로 입력하셔야 합니다.");
        }
    }

    private Cars makeCars(String carNames) {
        String[] entries = carNames.split(SEPARATOR);

        for (String name : entries) {
            isValidName(name);
        }

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
