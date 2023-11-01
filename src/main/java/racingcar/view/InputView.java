package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.MessageConstants;
import racingcar.domain.Car;
import racingcar.util.StringUtil;
import racingcar.validator.CarNameValidator;
import racingcar.validator.NumberValidator;

import java.util.List;


public class InputView {

    public List<Car> readCarNames() {
        System.out.println(MessageConstants.INPUT_CAR_NAME_MESSAGE);
        return new CarNameValidator(StringUtil.convertToList(Console.readLine()))
                .carNames()
                .stream()
                .map(Car::new)
                .toList();
    }

    public int readRoundCount() {
        System.out.println(MessageConstants.INPUT_ROUND_MESSAGE);
        return new NumberValidator(Console.readLine().trim())
                .getNumber();
    }
}
