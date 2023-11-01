package racingcar.resolver;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;

public class InputResolver {

    private static final int MAX_NAME_LENGTH = 5;
    private final InputView inputView;
    public InputResolver(InputView inputView) {
        this.inputView = inputView;
    }

    public List<String> preprocessCarName() {
        String carNames = inputView.inputCarNames();

        List<String> carNameList = Arrays.stream(carNames.split(","))
                .map(String::trim)
                .distinct()
                .toList();

        return limitNameSize(carNameList);
    }

    private static List<String> limitNameSize(List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("차의 이름은 5자 이하만 가능하다.");
            }
        }
        return carNameList;
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
