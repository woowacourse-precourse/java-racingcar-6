package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Circuit;
import racingcar.domain.TryCount;
import racingcar.util.TypeConvertor;

import java.util.List;

public class InputView {

    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public Circuit getInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> convertCarNames = TypeConvertor.stringToIntegerList(input);
        return Circuit.fromCarNames(convertCarNames);
    }

    public TryCount getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        Integer convertTryCount = TypeConvertor.stringToInt(input);
        return TryCount.of(convertTryCount);
    }
}
