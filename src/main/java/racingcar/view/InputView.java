package racingcar.view;

import static racingcar.exception.InputException.validateInputCount;
import static racingcar.exception.InputException.validateInputName;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();

    }
    public List<String> getSplitCarNames(String names) {
        List<String> carNames = List.of(names.split(","));
        validateInputName(carNames);
        return carNames;
    }

    public int getMoveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int moveCount;
        try {
            moveCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요");
        }
        validateInputCount(moveCount);
        return moveCount;
    }
}

