package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.CarList;
import racingcar.validator.Validator;
import racingcar.view.RacingView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingController {

    private final RacingView racingView;

    public RacingController(RacingView racingView) {
        this.racingView = racingView;
    }

    public void startRacing() {
        List<String> carNames = inputCarName();
        int forwardCount = inputForwardCount();
        CarList carList = new CarList(carNames);

        racingView.printExecutionResults();
        IntStream.range(0, forwardCount).forEach(i -> {
            carList.race();
            racingView.printExecutionResultsForEachOrder(carList);
        });

        racingView.printResult(carList);
    }

    private List<String> inputCarName() {
        racingView.printInputCarName();
        List<String> carNames = divideCarNamesByComma(Console.readLine());
        Validator.validateCarNames(carNames);

        return carNames;
    }

    private int inputForwardCount() {
        racingView.printReceiveNumber();
        String answer = Console.readLine();
        Validator.validateCarTrying(answer);

        return Integer.parseInt(answer);
    }

    private List<String> divideCarNamesByComma(String carNames) {
        return new ArrayList<>(List.of(carNames.split(",")));
    }
}
