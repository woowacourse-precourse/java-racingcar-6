package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Garage;
import racingcar.util.TypeConvertor;

import java.util.List;

public class InputView {

    private static final InputView instance = new InputView();

    private static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public Garage getInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> convertCarNames = TypeConvertor.stringToIntegerList(input);
        return Garage.fromCarNames(convertCarNames);
    }
}
