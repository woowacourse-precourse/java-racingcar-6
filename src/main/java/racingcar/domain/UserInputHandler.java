package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.message.GameMessage;
import racingcar.utils.StringGenerator;
import racingcar.validation.InputValidator;

public class UserInputHandler {
    public List<String> getCarNameInput(){
        System.out.println(GameMessage.CAR_NAME_INPUT_NOTICE.getMessage());
        String nameString = Console.readLine();
        InputValidator.validateNull(nameString);

        List<String> carNames = StringGenerator.generateCarName(nameString, ",");
        for (String carName: carNames) {
            InputValidator.validateLength(carName, 5);
        }
        return carNames;
    }

    public Integer getRacingCnt(){
        System.out.println(GameMessage.TRY_CNT_INPUT_NOTICE.getMessage());
        String cntString = Console.readLine();
        InputValidator.validateNumber(cntString);
        return Integer.parseInt(cntString);
    }
}
