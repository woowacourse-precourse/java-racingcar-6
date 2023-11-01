package racingcar.resolver;

import camp.nextstep.edu.missionutils.Console;
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
        return removeSpace(carNameList);
    }

    private static String[] splitByComma(String carNames) {
        return carNames.split(",");
    }

    private List<String> removeDuplicates(String[] splitCarNames) {
        return Arrays.stream(splitCarNames)
                .distinct()
                .toList();
    }

    private List<String> removeSpace(List<String> splitInput) {
        return splitInput.stream()
                .map(String::trim)
                .toList();
    }

    public int preprocessCount() {
        String count = inputView.inputCount();

        return stringToInt(count.trim());
    }

    private static int stringToInt(String trimInput) {
        int count;
        try {
            count = Integer.parseInt(trimInput);
        } catch (Exception e) {
            Console.close();
            throw new IllegalArgumentException("숫자가 아닌 값을 횟수 값으로 입력할 수 없습니다.");
        }
        return count;
    }

}
