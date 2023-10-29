package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.utils.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private int attemptNum;
    private final Parser parser = new Parser();
    private final ArrayList<Car> carRepository = new ArrayList<Car>();

    public void run() {
        saveCars(parser.parseInputCarNames(getCarNamesByInput()));
        OutputView.printExecutionResult();
        attemptNum = getAttemptNumberByInput();
        for (int i = 0; i < attemptNum; i++)
        {
            decideMovement();
            OutputView.printCarScore(carRepository);
            System.out.println();
        }
    }

    private void saveCars(List<String> carNames) {
        for (String carName : carNames) {
            carRepository.add(new Car(carName));
        }
    }
    private String getCarNamesByInput() {
        InputView.requestCarName();
        String input = Console.readLine();
        return input;
    }

    private int getAttemptNumberByInput() {
        InputView.requestAttemptNumber();
        int attemptNum = Integer.parseInt(Console.readLine());
        return attemptNum;
    }
    private void decideMovement() {
        for (int i = 0; i < carRepository.size(); i++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                carRepository.get(i).moveForward(1);
            }
        }
    }
}
