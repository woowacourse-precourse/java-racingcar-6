package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;

public class InputResolver {
    private final InputView inputView;

    public InputResolver(InputView inputView) {
        this.inputView = inputView;
    }

    public List<String> preprocessCarName() {
        String carNames = inputView.inputCarNames();

        String[] splitCarNames = splitByComma(carNames);
        List<String> carNameList = removeDuplicates(splitCarNames);
        return removeSpaceCarName(carNameList);
    }

    private static String[] splitByComma(String carNames) {
        return carNames.split(",");
    }

    private List<String> removeDuplicates(String[] splitCarNames) {
        return Arrays.stream(splitCarNames)
                .distinct()
                .toList();
    }

    private List<String> removeSpaceCarName(List<String> splitInput) {
        return splitInput.stream()
                .map(String::trim)
                .toList();
    }




}
