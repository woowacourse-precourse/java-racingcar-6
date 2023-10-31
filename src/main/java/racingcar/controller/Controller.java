package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.util.Parsing;
import racingcar.util.Validation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {

    private final Parsing parsing = new Parsing();
    private final Validation validation = new Validation();
    private final CarRepository carRepository = new CarRepository();

    public void run() {
        saveCars(parsing.parseCarNames(getCarNamesByInput()));
    }

    private void saveCars(List<String> carNames) {
        for (String carName : carNames) {
            carRepository.save(new Car(carName));
        }
    }

    private String getCarNamesByInput() {
        InputView.requestInputMessage();
        String input = Console.readLine();

        try {
            validation.checkCarNamesInput(input);
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return getCarNamesByInput();
        }
    }
}
