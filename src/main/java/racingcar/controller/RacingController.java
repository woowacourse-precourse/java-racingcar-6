package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.ExceptionMessage;
import racingcar.model.CarList;
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
        validateCarNames(carNames);

        return carNames;
    }

    private int inputForwardCount() {
        racingView.printReceiveNumber();
        String answer = Console.readLine();
        validateCarTrying(answer);

        return Integer.parseInt(answer);
    }

    private void validateCarTrying(String answer) {
        if (!isAnswerDigit(answer) || !isAnswerPositiveNumber(answer)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER);
        }
    }

    private boolean isAnswerDigit(String answer) {
        return answer.chars().allMatch(Character::isDigit);
    }

    private boolean isAnswerPositiveNumber(String answer) {
        return Integer.parseInt(answer) > 0;
    }

    private void validateCarNames(List<String> carNames) {
        if (!isFiveCharactersOrLess(carNames)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_MORE_THAN_FIVE);
        }
    }

    private List<String> divideCarNamesByComma(String carNames) {
        return new ArrayList<>(List.of(carNames.split(",")));
    }

    private boolean isFiveCharactersOrLess(List<String> carNames) {
        return carNames.stream().allMatch(carName -> carName.length() <= 5);
    }
}
