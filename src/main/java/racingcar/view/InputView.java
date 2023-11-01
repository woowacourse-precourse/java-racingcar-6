package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.util.Util;
import racingcar.util.validator.AttemptCountValidator;
import racingcar.util.validator.CarNameValidator;

public class InputView {
    public List<String> inputToNameCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        CarNameValidator.getInstance().validate(input);
        return Util.splitNameByComma(input);
    }

    public int inputAttemptToMoveCar() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        AttemptCountValidator.getInstance().validate(input);
        return Util.convertStringToInt(input);
    }
}
