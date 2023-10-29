package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.ExceptionMessage;
import racingcar.view.RacingView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    private final RacingView racingView;

    public RacingController(RacingView racingView) {
        this.racingView = racingView;
    }

    private List<String> inputCarName() {
        racingView.printInputCarName();
        List<String> carNames = divideCarNamesByComma(Console.readLine());
        validateCarNames(carNames);

        return carNames;
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
