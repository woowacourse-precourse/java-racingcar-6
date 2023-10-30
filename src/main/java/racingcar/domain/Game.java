package racingcar.domain;

import racingcar.utils.InputException;
import racingcar.utils.Split;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public void run() {
        Cars cars = generateCarList(InputView.inputCarName());
        int repeat = InputView.inputNumberOfMoves();
        playRound(repeat, cars);
        cars.showFinalWinner();
    }

    public Cars generateCarList(String input) {
        List<String> carNames = Split.splitString(input);
        InputException.validateNameDuplication(carNames);
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            InputException.validateNameSize(carName);
            carList.add(new Car(carName));
        }
        return new Cars(carList);
    }

    public void playRound(int repeat, Cars cars) {
        System.out.println(PrintMessage.PRINT_EXECUTION_RESULT);
        for (int i = 0; i < repeat; i++) {
            cars.moveOrStop();
            cars.showResult();
        }
    }
}