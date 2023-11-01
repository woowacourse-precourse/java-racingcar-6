package service;

import camp.nextstep.edu.missionutils.Console;
import utils.TransformUtil;
import utils.validation.CarValidation;
import utils.validation.UserInputValidation;

import java.util.List;

public class UserInputService {
    public List<String> carName() {
        List<String> carNames
                = TransformUtil.commasToList(Console.readLine());

        CarValidation.carName(carNames);

        return carNames;
    }

    public Integer roundCnt(String round) {
        return UserInputValidation.checkNumber(round);
    }
}
