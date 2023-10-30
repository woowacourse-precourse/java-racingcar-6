package racingcar.view;

import static racingcar.exception.InputException.validateInputCount;
import static racingcar.exception.InputException.validateInputName;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String name = Console.readLine();
        List<String> names = Arrays.asList(name.split(","));
        validateInputName(names);
        return names;
    }

    public int getMoveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int moveCount = Integer.parseInt(Console.readLine());
        validateInputCount(moveCount);
        return moveCount;
    }
}

