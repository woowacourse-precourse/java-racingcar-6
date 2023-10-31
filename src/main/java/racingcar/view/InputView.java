package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.TryCount;
import racingcar.validator.GameValidator;

import java.util.List;

public class InputView {

    public Cars inputCarNames() {

        List<String> cars = getCars();

        return new Cars(cars.stream()
                .map(String::trim)
                .map(Name::new)
                .map(Car::new)
                .toList());
    }

    public TryCount inputTryCount() {

        String tryCountString = Console.readLine();
        GameValidator.validateIsNumber(tryCountString);

        int tryCount = Integer.parseInt(tryCountString);

        return new TryCount(tryCount);
    }

    private List<String> getCars() {

        String cars = Console.readLine();
        GameValidator.validateCarNumberIsOverTwo(cars);
        GameValidator.validateZeroCarName(cars);

        return GameValidator.validateDuplicateCarNames(cars);
    }
}
